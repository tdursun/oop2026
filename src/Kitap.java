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

}//Kitap
