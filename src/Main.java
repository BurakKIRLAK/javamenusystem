
import java.util.Scanner;
import java.util.Arrays;


public class Main {


    static  void admin_menu(){
        System.out.println("İŞLEMLER");
        System.out.println("--------------------------------------------");
        System.out.println("1) Okul bilgileri"); //Kullanıcı yetkisi ve üstü
        System.out.println("2) Kişisel bilgiler"); //Sadece admin yetkisi
        System.out.println("3) Proje detayları"); // Tüm yetkiler
        System.out.println("4) İletişim bilgileri"); // Tüm yetkiler
        System.out.println("0) Programı kapat!"); // Tüm yetkiler
    }

    static void standard_user_menu(){
        System.out.println("İŞLEMLER");
        System.out.println("--------------------------------------------");
        System.out.println("1) Okul bilgileri"); //Kullanıcı yetkisi ve üstü
        System.out.println("2) Proje detayları"); // Tüm yetkiler
        System.out.println("3) İletişim bilgileri"); // Tüm yetkiler
        System.out.println("0) Programı kapat!"); // Tüm yetkiler
    }

    static void case1(){
        System.out.println("|OKUL BİLGİLERİ|");
        System.out.println("Okul Numarası: 250504003");
        System.out.println("Bölümü: Yazılım Mühendisliği");
        System.out.println("Sınıfı: 1");
        System.out.println("Not ortalaması: 3.17");


    }

    static void case2(){
        System.out.println("|KİŞİSEL BİLGİLER|");
        System.out.println("Merhaba! Adım Burak Atlas Üniveristesi Yazılım Mühendisliği\n " +
                "1. sınıf öğrencisiyim. Kodlamayı ve projeler geliştirmeyi seviyorum." );
    }

    static void case3 (){
        System.out.println("|PROJE DETAYLARI|");
        System.out.println("Bu projenin tamamını Java bilgilerimi kullanarak \n " +
                "hazırladım ve burada kendimi tanıtıyorum. " );
    }

    static void case4 (){
        System.out.println("|İLETİŞİM BİLGİLERİ|");
        System.out.println("Instagram: https://www.instagram.com/hankirlak/");
        System.out.println("GitHub: https://github.com/BurakKIRLAK");
        System.out.println("LinkedIN: https://www.linkedin.com/in/burak-kirlak-6a8022372/");
    }







    //------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("Hoşgeldiniz! Lütfen kullanıcı adınızı girin: ");
        System.out.println("Eğer misafir girişi yapacaksanız \" Enter \" tuşuna basabilirsiniz. ");
        String admin_user_name[] = {"burak", "murat", "furkan"};//Admin listesi
        char checkAdmin[] = {'A', 'U', 'G'};//Yetki profilleri.

        Scanner input  = new Scanner(System.in);
        String user_name = input.nextLine();
        String admin_user_name[] = {"burak", "murat", "furkan"};//Admin listesi
        char checkAdmin[] = {'A', 'U', 'G'};//Yetki profilleri.
        boolean isAdmin = Arrays.asList(admin_user_name).contains(user_name); // İsmin listede olup olmadığını kontrol eder.
        char admin_value;


        if (user_name.isBlank()){ //Eğer isim girilmezse misafir olarak kabul eder.
            admin_value = checkAdmin[2]; //Giriş yöntemine göre şifre oluşturma için yetki profili seçer.
            System.out.println("Misafir olarak giriş yaptınız. Kodunuz: ");

        }
        else if (isAdmin) { //Eğer isim admin listesinde varsa admin olarak kabul eder.
            admin_value = checkAdmin[0];
            System.out.println("Admin olarak giriş yaptınız. Kodunuz: ");

        }

        else { //Eğer isim listede yoksda standart kullanıcı olarak kabul eder.
            admin_value = checkAdmin[1];
            System.out.println("Kullanıcı olarak giriş yaptınız. Kodunuz: ");
        }


        while (true) {
            int standard_passkey = (int) (Math.random() * 1000000); //Şifrenin kemik halini oluşturur.
            String passkey = String.valueOf(standard_passkey); //Şifreyi sayı olmaktan kurtarır ve metine dönüştürür.
            int admin_check = (int) (Math.random() * 6); //Şifre içindeki 6 konumdan birini seçer.
            StringBuilder create_key = new StringBuilder(passkey); //Şifre içindeki değerlerlerden birini yetki profili ile değiştirmek için gereken metod.
            create_key.insert(admin_check, admin_value);//Şifre içindeki değerlerlerden birini yetki profili ile değiştirir.
            String theKey = create_key.toString();//Şifrenin son halini verir.
            System.out.println(theKey);
            System.out.println("----------------------------------------------------------------------------------------");

            System.out.println("Lütfen kodunuzu giriniz:  ");
            String entered_user_passkey = input.nextLine();

            if (entered_user_passkey.equals(theKey)) { //Şifrenin aynı olup olmadığını kontrol eder.
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

            admin_menu();
            int choise = input.nextInt();
            boolean isSystemActive = true;

            while(isSystemActive) {

                switch (choise) {
                    case 1:
                        case1();
                        choise = input.nextInt();
                        break;
                    case 2:
                        case2();
                        choise = input.nextInt();
                        break;
                    case 3:
                        case3();
                        choise = input.nextInt();
                        break;
                    case 4:
                        case4();
                        choise = input.nextInt();
                        break;
                    case 0:
                        isSystemActive = false;
                        break;
                    default:
                        System.out.println("Yanlış giriş! Lütfen menüdeki seçeneklerden birini deneyin.");
                        choise = input.nextInt();
                        break;
                }

            }

        }else {

            standard_user_menu();
            int choise = input.nextInt();
            boolean isSystemActive = true;

            while(isSystemActive) {
                switch (choise) {
                    case 1:
                        case1();
                        choise = input.nextInt();
                        break;
                    case 2:
                        case3();
                        choise = input.nextInt();
                        break;
                    case 3:
                        case4();
                        choise = input.nextInt();
                        break;
                    case 0:
                        isSystemActive = false;
                        break;
                    default:
                        System.out.println("Yanlış giriş! Lütfen menüdeki seçeneklerden birini deneyin.");
                        choise = input.nextInt();
                        break;
                }

            }
            System.out.println("Program sonlandırıldı.");
        }

    }
}
