import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private static final List<Kitap> kutuphane = new ArrayList<>();

    private static void kutuphaneListeYazdir() {
        for (Kitap kitap : kutuphane) {
            System.out.println(kitap.kitapBilgisi());
            for (KitapKopyasi kopya : kitap.getFizikselKopyalar()) {
                System.out.println("  " + kopya.kopyaBilgisi());
                //odunc kayitlarını yazdir
                // kopya.getOduncAlmalar();
                for (OduncKaydi kayit : kopya.getOduncAlmalar()) {
                   System.out.println("  " + kayit.oduncBilgisi()); 
                }

            }
        }
    }
    public static void main(String[] args) 
    {
        //ilk kitap ekleniyor
        Kitap kitap1 = new Kitap(
            "9780132350884",
            "Clean Code",
            "Robert C. Martin",
            2008
        );
        kutuphane.add(kitap1);
        
        KitapKopyasi kopya1_1 = new KitapKopyasi("29M-001", kitap1);
        KitapKopyasi kopya1_2 = new KitapKopyasi("29M-002", kitap1);
    
        
        //System.out.println(kopya1.getDurum());

        // 2. Örnek: Algoritmalar (Ödünç Verildi)
        Kitap kitap2 = new Kitap("9780262033848", "Introduction to Algorithms", "Thomas H. Cormen", 2009);
        kutuphane.add(kitap2);
        KitapKopyasi kopya2_1 = new KitapKopyasi("29M-003", kitap2);
    

        Uye uye1 = new Uye("U001", "Ayşe Yılmaz", "ayse@29mayis.edu.tr", "sifre123", "Tarih");
        Uye uye2 = new Uye("U001", "Azra Eren", "azra@29mayis.edu.tr", "sifre12345", "Bilim Kurgu");
        KutuphaneGorevlisi gorevli = new KutuphaneGorevlisi(
            "G001", "Mehmet Demir", "mehmet@29mayis.edu.tr", "sifre", "I29-1235"
        );
        //Kullanici k = new Kullanici("deneme","user","a@gmail.com","123");
        System.out.println(uye1.getInfo());
        System.out.println(uye2.getInfo());
        System.out.println(gorevli.getInfo());

        OduncKaydi odunc1 = new OduncKaydi(
            "O001",
            LocalDate.now(),
            LocalDate.now().plusDays(14),
            null,
            uye1,
            kopya1_2
        );


        OduncKaydi odunc2 = new OduncKaydi(
            "O002",
            LocalDate.now(),
            LocalDate.now().plusDays(21),
            null,
            uye2,
            kopya2_1
        );
        //System.out.println(uye1.getAd() + " için işlem: " + odunc.getIslemNo());
        //System.out.println("Görevli: " + gorevli.getAd());

        kutuphaneListeYazdir();

    }//main

}
