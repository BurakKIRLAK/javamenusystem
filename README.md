[README.md](https://github.com/user-attachments/files/29352576/README.md)
# 🖥️ Burak Kırlak Java Terminali (Yetkilendirmeli Menü Sistemi)

Java dili kullanılarak geliştirilmiş, dinamik tek kullanımlık şifre (OTP) üreten ve kullanıcı rollerine (Admin, Standart Kullanıcı, Misafir) göre dinamik menü yönetimi sağlayan konsol tabanlı bir otomasyon uygulamasıdır.

---

## 🚀 Proje Özellikleri

* **Dinamik Rol Ataması:** Girilen kullanıcı adına göre sistem otomatik olarak **Admin (A)**, **Kullanıcı (U)** veya **Misafir (G)** profili belirler.
* **Gelişmiş Güvenlik Donanımı (OTP):** Her giriş denemesinde arka planda `Math.random()` ile 6 haneli rastgele bir sayı dizisi üretilir ve bu dizinin rastgele bir indeksine kullanıcının yetki harfi gömülerek benzersiz bir doğrulama kodu (Token) oluşturulur.
* **Hatalı Giriş Koruması:** Doğrulama kodu yanlış girildiğinde sonsuz döngü mimarisi sayesinde sistem kendini korumaya alır ve anında yepyeni bir kod üreterek kullanıcıdan tekrar doğrulama ister.
* **Rol Bazlı Dinamik Menü:** Admin yetkisine sahip kullanıcılar tüm kişisel ve akademik verilere erişebilirken, Standart ve Misafir kullanıcılar sadece kendilerine izin verilen menüleri görebilirler.
* **FSM (Sonlu Durum Makinesi) Menü Akışı:** Kullanıcı menü içinde işlem yaptıktan sonra program kapanmaz; `while` döngüsü ve `switch-case` yapısının harmanlanmasıyla sürekli aktif kalır ve tekrar seçim yapılmasına olanak tanır.

---

## ⚙️ Sistem Mimarisi ve Algoritma Akışı

Sistem temel olarak iki ana aşamadan oluşmaktadır: **Kimlik Doğrulama/Şifreleme** ve **İçerik Yönetim Paneli**.

### 1. Rol Belirleme Tablosu
| Kullanıcı Girişi | Atanan Rol | Yetki Kodu | Görünür Menü Seçenekleri |
| :--- | :--- | :---: | :--- |
| `burak`, `murat`, `furkan` | Admin | **A** | Okul, Kişisel, Proje, İletişim, Çıkış |
| *Herhangi bir isim* | Standart Kullanıcı | **U** | Okul, Proje, İletişim, Çıkış |
| *Hiçbir şey yazmadan Enter* | Misafir | **G** | Okul, Proje, İletişim, Çıkış |

### 2. Şifre Üretim Algoritması
```
[Rastgele 6 Haneli Sayı] ──> Örn: 542910
[Rastgele İndeks (0-6)]  ──> Örn: 3. İndeks
[Kullanıcı Yetki Kodu]   ──> Örn: 'A'
🔥 OLUŞAN TOKEN          ──> 542A910
```

---

## 🛠️ Kod Yapısı ve Kullanılan Metotlar

Proje, temiz kod yazım ilkelerine uygun olarak modüler bir yapıda tasarlanmıştır.

### 🔹 Modüler Arayüz Metotları (Static Methods)

* `static void admin_menu()`
    * **Görevi:** Admin rolündeki kullanıcılara sunulacak olan 5 opsiyonlu tam yönetim panelini ekrana yazdırır.
* `static void standard_user_menu()`
    * **Görevi:** Standart ve misafir kullanıcılar için sınırlandırılmış 4 opsiyonlu menü arayüzünü görüntüler.
* `static void case1()`, `case2()`, `case3()`, `case4()`
    * **Görevi:** Kodun okunabilirliğini artırmak ve `main` metodunu kalabalıktan kurtarmak için verileri (akademik bilgiler, biyografi, proje detayları ve sosyal medya linkleri) paket halinde ekrana basan fonksiyonel gövdelerdir.

### 🔹 Temel Programlama Mantığı ve Algoritma Kuralları

#### 1. Metinsel Doğrulama ve Kontroller (String Handling)
* **`user_name.isBlank()`**: Kullanıcının sadece boşluk tuşuna basıp basmadığını veya direkt Enter ile geçip geçmediğini denetler. Boşsa sistem otomatik olarak `Misafir` modunu tetikler.
* **`Arrays.asList(...).contains(user_name)`**: Statik olarak tanımlanmış admin listesinin içinde girilen kullanıcı adının var olup olmadığını tek satırda ve yüksek performansla sorgular.

#### 2. Dinamik Şifreleme Teknolojisi (Math & StringBuilder)
* **`Math.random()`**: `double` tipinde rastgele değerler üreterek hem kemik şifreyi (`standard_passkey`) hem de karakter yerleşim noktasını (`admin_check`) dinamik olarak belirler.
* **`StringBuilder.insert(index, value)`**: Performans dostu string manipülasyonu sağlar. Mevcut sayı dizisini bozmadan, araya yetki karakterini sızdırmak için kullanılmıştır.

#### 3. Kontrol Akışı ve Sonsuz Döngüler (Control Flow)
* **`while(true) + break` (Şifre Döngüsü):** Kullanıcı doğru şifreyi girene kadar sistemi kilitleyen yapıdır. Şifre doğru girildiğinde `break;` komutu ile döngü kırılır.
* **`while(isSystemActive) + switch-case` (Menü Döngüsü):** Kullanıcının menüler arasında çıkış yapmadan özgürce gezinebilmesini sağlar. Her `case` bloğunun sonunda kullanıcıdan yeni bir `choise (seçim)` girdisi alınarak sistem durumu güncellenir ve döngü başa sarar. `case 0` tetiklendiğinde `isSystemActive = false` yapılarak program güvenli bir şekilde kapatılır.

---

## 💻 Kurulum ve Çalıştırma

### Gereksinimler
* **Java Development Kit (JDK):** JDK 11 veya üzeri sürüm.

### Derleme ve Çalıştırma Adımları

1.  Proje dosyalarının bulunduğu klasörde terminali açın.
2.  Aşağıdaki komutu kullanarak projeyi derleyin:
    ```bash
    javac Main.java
    ```
3.  Derlenen programı çalıştırmak için şu komutu yürütün:
    ```bash
    java Main
    ```

---

## 📌 Geliştirici Bilgileri

* **Geliştirici:** Burak Kırlak
* **Bölüm:** Atlas Üniversitesi - Yazılım Mühendisliği (1. Sınıf)

* **İletişim:** [GitHub](https://github.com/BurakKIRLAK) | [LinkedIn](https://www.linkedin.com/in/burak-kirlak-6a8022372/) | [Instagram](https://www.instagram.com/hankirlak/)

---
> *Bu proje, Java temel kontrol yapıları, nesne yönelimli programlama öncesi algoritmik mantık ve dinamik veri manipülasyonu süreçlerini pekiştirmek amacıyla geliştirilmiştir.*
