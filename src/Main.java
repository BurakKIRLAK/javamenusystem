import java.util.*;

public class Main {

    static void adminMenu() {
        System.out.println("İŞLEMLER");
        System.out.println("--------------------------------------------");
        System.out.println("1) Okul bilgileri"); //Kullanıcı yetkisi ve üstü
        System.out.println("2) Kişisel bilgiler"); //Sadece admin yetkisi
        System.out.println("3) Proje detayları"); // Tüm yetkiler
        System.out.println("4) İletişim bilgileri"); // Tüm yetkiler
        System.out.println("0) Programı kapat!"); // Tüm yetkiler
    }

    static void standardUserMenu() {
        System.out.println("İŞLEMLER");
        System.out.println("--------------------------------------------");
        System.out.println("1) Okul bilgileri"); //Kullanıcı yetkisi ve üstü
        System.out.println("2) Proje detayları"); // Tüm yetkiler
        System.out.println("3) İletişim bilgileri"); // Tüm yetkiler
        System.out.println("0) Programı kapat!"); // Tüm yetkiler
    }

    static void case1() {
        System.out.println("|OKUL BİLGİLERİ|");
        System.out.println("Okul Numarası: 250504003");
        System.out.println("Bölümü: Yazılım Mühendisliği");
        System.out.println("Sınıfı: 1");
        System.out.println("Not ortalaması: 3.17");


    }

    static void case2() {
        System.out.println("|KİŞİSEL BİLGİLER|");
        System.out.println("Merhaba! Adım Burak Atlas Üniveristesi Yazılım Mühendisliği\n " +
                "1. sınıf öğrencisiyim. Kodlamayı ve projeler geliştirmeyi seviyorum.");
    }

    static void case3() {
        System.out.println("|PROJE DETAYLARI|");
        System.out.println("Bu projenin tamamını Java bilgilerimi kullanarak \n " +
                "hazırladım ve burada kendimi tanıtıyorum. ");
    }

    static void case4() {
        System.out.println("|İLETİŞİM BİLGİLERİ|");
        System.out.println("Instagram: https://www.instagram.com/hankirlak/");
        System.out.println("GitHub: https://github.com/BurakKIRLAK");
        System.out.println("LinkedIN: https://www.linkedin.com/in/burak-kirlak-6a8022372/");
    }

    static int getValidChoice(Scanner input) {
        int choice;
        try {
            choice = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Geçersiz giriş! Lütfen sayı girin.");
            input.nextLine();
            choice = -1;
        }
        return choice;
    }

    //-----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

            System.out.println("Hoşgeldiniz! Lütfen kullanıcı adınızı girin: ");
            System.out.println("Eğer misafir girişi yapacaksanız \" Enter \" tuşuna basabilirsiniz. ");
            Scanner input = new Scanner(System.in);
            String      userName = input.nextLine();
            String[]    adminUserName = {"burak", "murat", "furkan"};//Admin listesi
            char[]      checkAdmin = {'A', 'U', 'G'};//Yetki profilleri.
            boolean     isAdmin = Arrays.asList(adminUserName).contains(userName); // İsmin listede olup olmadığını kontrol eder.
            char        adminValue;

            if (userName.isBlank()) { //Eğer isim girilmezse misafir olarak kabul eder.
                adminValue = checkAdmin[2]; //Giriş yöntemine göre şifre oluşturma için yetki profili seçer.
                System.out.println("Misafir olarak giriş yaptınız. Kodunuz: ");

            } else if (isAdmin) { //Eğer isim admin listesinde varsa admin olarak kabul eder.
                adminValue = checkAdmin[0];
                System.out.println("Admin olarak giriş yaptınız. Kodunuz: ");

            } else { //Eğer isim listede yoksda standart kullanıcı olarak kabul eder.
                adminValue = checkAdmin[1];
                System.out.println("Kullanıcı olarak giriş yaptınız. Kodunuz: ");
            }

            while (true) {
                int standardPasskey = (int) (Math.random() * 1000000); //Şifrenin kemik halini oluşturur.
                String passkey = String.valueOf(standardPasskey); //Şifreyi sayı olmaktan kurtarır ve metine dönüştürür.
                int adminCheck = (int) (Math.random() * 6); //Şifre içindeki 6 konumdan birini seçer.
                StringBuilder createKey = new StringBuilder(passkey); //Şifre içindeki değerlerlerden birini yetki profili ile değiştirmek için gereken metod.
                createKey.insert(adminCheck, adminValue);//Şifre içindeki değerlerlerden birini yetki profili ile değiştirir.
                String theKey = createKey.toString();//Şifrenin son halini verir.
                System.out.println(theKey);
                System.out.println("----------------------------------------------------------------------------------------");

                System.out.println("Lütfen kodunuzu giriniz:  ");
                String enteredUserPasskey = input.nextLine();

                if (enteredUserPasskey.equals(theKey)) { //Şifrenin aynı olup olmadığını kontrol eder.
                    System.out.println("Giriş yapıldı");
                    break;
                } else {
                    System.out.println("Hatalı kod!!!");
                    System.out.println("Yeni şifre ile tekrar deneyiniz: ");
                }
            }

            System.out.println("--------------------------------------------");
            System.out.println("|BURAK KIRLAK JAVA TERMİNALİNE HOŞ GELDİNİZ|");
            System.out.println("--------------------------------------------");

            if (isAdmin) {
                adminMenu();
                int choice;
                //Exeption Handling düzenlemesi. choice değerini if ve diğer döngülerin okuyabilmesi için dışarıda bıraktık.
                //Sadece scanner metodunu try içine aldık ve catch ile tekrardan değer girilmesini istedik.
                choice = getValidChoice(input);

                boolean isSystemActive = true;

                while (isSystemActive) {

                    switch (choice) {
                        case 1:
                            case1();
                            choice = getValidChoice(input);
                            break;
                        case 2:
                            case2();
                            choice = getValidChoice(input);
                                break;
                        case 3:
                            case3();
                            choice = getValidChoice(input);
                            break;
                        case 4:
                            case4();
                            choice = getValidChoice(input);
                            break;
                        case 0:
                            isSystemActive = false;
                            break;
                        default:
                            System.out.println("Yanlış giriş! Lütfen menüdeki seçeneklerden birini deneyin.");
                            choice = getValidChoice(input);
                            break;
                    }

                }
                System.out.println("Program sonlandırıldı.");

            } else {

                standardUserMenu();
                int choice ;
                choice = getValidChoice(input);
                boolean isSystemActive = true;

                while (isSystemActive) {
                    switch (choice) {
                        case 1:
                            case1();
                            choice = getValidChoice(input);
                            break;
                        case 2:
                            case3();
                            choice = getValidChoice(input);
                            break;
                        case 3:
                            case4();
                            choice = getValidChoice(input);
                            break;
                        case 0:
                            isSystemActive = false;
                            break;
                        default:
                            System.out.println("Yanlış giriş! Lütfen menüdeki seçeneklerden birini deneyin.");
                            choice = getValidChoice(input);
                            break;
                    }

                }
                System.out.println("Program sonlandırıldı.");
            }
        }
    }
