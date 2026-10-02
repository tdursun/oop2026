public class Kitap {
    private String isbn;
    private String baslik;
    private String yazar;
    private int yayinYili;
    private String durum;
    
    // TODO Kompozisyon İlişkisi (1 -> 1..*): Kitap yoksa kopyası da olamaz.

    //Constructor method
    public Kitap(String isbn, String baslik, String yazar, int yayinYili, String durum) {
        this.isbn = isbn;
        this.baslik = baslik;
        this.yazar = yazar;
        this.yayinYili = yayinYili;
        this.durum = durum;
    }

    // Kitap bilgilerine erisim metodları
    public String kitapBilgisi() {
        String tanitim = "ADI: "+this.title + " YAZARI: "+this.yazar+
                        " yayın yılı: "+this.yayinYili+" ISBN: "+this.isbn;
        return tanitim;
    }

    public String getBaslik(){
        return this.baslik;
    }

    public String getYazar(){
        return this.yazar;
    }

    public static void main(String[] args){
	// some code here in the main() method

        //Kitap sınıfından nesneler create ediyoruz

        // 1. Örnek: Temiz Kod Yazma (Rafta)
        Kitap kitapTeknik1 = new Kitap("9780132350884", "Clean Code", "Robert C. Martin", 2008, "Rafta");

        // 2. Örnek: Algoritmalar (Ödünç Verildi)
        Kitap kitapTeknik2 = new Kitap("9780262033848", "Introduction to Algorithms", "Thomas H. Cormen", 2009, "Ödünç Verildi");

        // 3. Örnek: Tasarım Kalıpları (Mevcut)
        Kitap kitapTeknik3 = new Kitap("9780201633610", "Design Patterns", "Erich Gamma", 1994, "Mevcut");

        // 4. Örnek: Yapay Zeka (Ödünç Verildi)
        Kitap kitapTeknik4 = new Kitap("9780134610993", "Artificial Intelligence: A Modern Approach", "Stuart Russell", 2020, "Ödünç Verildi");

        // 5. Örnek: Veri Bilimi ve Python (Kayıp)
        Kitap kitapTeknik5 = new Kitap("9781491957660", "Python for Data Analysis", "Wes McKinney", 2017, "Kayıp");
        
        // 3. Örnek: Türk Edebiyatı Klasikleri (Mevcut)
        Kitap kitapEdebi1 = new Kitap("9789754586978", "Kürk Mantolu Madonna", "Sabahattin Ali", 2006, "Mevcut");

        // 4. Örnek: Popüler Bilim (Ödünç Verildi)
        Kitap kitapSp = new Kitap("9786052994917", "Sapiens", "Yuval Noah Harari", 2018, "Ödünç Verildi");

        // 5. Örnek: Distopya (Kayıp)
        Kitap kitap1884 = new Kitap("9789750719388", "1844", "George Orwell", 2000, "Kayıp");

        System.out.println(kitapEdebi1.kitapBilgisi());

    }//main

}//Kitap
