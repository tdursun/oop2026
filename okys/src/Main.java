public class Main {
    public static void main(String[] args) 
    {
        //ilk kitap ekleniyor
        Kitap kitap1 = new Kitap(
            "9780132350884",
            "Clean Code",
            "Robert C. Martin",
            2008
        );
        
        System.out.println(kitap1.getDurum());
        // MEVCUT
        
        kitap1.oduncVer();
        
        System.out.println(kitap1.getDurum());
        // ODUNC_VERILDI
        
        kitap1.teslimAl();
        
        System.out.println(kitap1.getDurum());
        // MEVCUT

        // 2. Örnek: Algoritmalar (Ödünç Verildi)
        Kitap kitapTeknik2 = new Kitap("9780262033848", "Introduction to Algorithms", "Thomas H. Cormen", 2009);

        // 3. Örnek: Tasarım Kalıpları (Mevcut)
        Kitap kitapTeknik3 = new Kitap("9780201633610", "Design Patterns", "Erich Gamma", 1994);

        // 4. Örnek: Yapay Zeka (Ödünç Verildi)
        Kitap kitapTeknik4 = new Kitap("9780134610993", "Artificial Intelligence: A Modern Approach", "Stuart Russell", 2020);

        // 5. Örnek: Veri Bilimi ve Python (Kayıp)
        Kitap kitapTeknik5 = new Kitap("9781491957660", "Python for Data Analysis", "Wes McKinney", 2017);
        
        // 3. Örnek: Türk Edebiyatı Klasikleri (Mevcut)
        Kitap kitapEdebi1 = new Kitap("9789754586978", "Kürk Mantolu Madonna", "Sabahattin Ali", 2006);

        // 4. Örnek: Popüler Bilim (Ödünç Verildi)
        Kitap kitapSp = new Kitap("9786052994917", "Sapiens", "Yuval Noah Harari", 2018);

        // 5. Örnek: Distopya (Kayıp)
        Kitap kitap1884 = new Kitap("9789750719388", "1844", "George Orwell", 2000);


    }
}
