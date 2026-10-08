import java.util.ArrayList;
import java.util.List;

public class Kitap {

    private final String isbn;
    private String baslik;
    private String yazar;
    private int yayinYili;
    private KitapDurumu durum;
    private final List<KitapKopyasi> kopyalar = new ArrayList<>();

    public Kitap(
            String isbn,
            String baslik,
            String yazar,
            int yayinYili) {

        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException(
                "ISBN boş olamaz."
            );
        }

        if (baslik == null || baslik.isBlank()) {
            throw new IllegalArgumentException(
                "Başlık boş olamaz."
            );
        }

        if (yazar == null || yazar.isBlank()) {
            throw new IllegalArgumentException(
                "Yazar boş olamaz."
            );
        }

        if (yayinYili <= 0) {
            throw new IllegalArgumentException(
                "Yayın yılı geçersiz."
            );
        }

        this.isbn = isbn;
        this.baslik = baslik;
        this.yazar = yazar;
        this.yayinYili = yayinYili;
        this.durum = KitapDurumu.MEVCUT;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public int getYayinYili() {
        return yayinYili;
    }

    public KitapDurumu getDurum() {
        return durum;
    }

    public java.util.List<KitapKopyasi> getKopyalar() {
        return java.util.Collections.unmodifiableList(kopyalar);
    }

    public void kitapKopyasiEkle(KitapKopyasi kopya) {
        if (kopya == null) {
            throw new IllegalArgumentException("Kitap kopyası boş olamaz.");
        }

        if (kopya.getKitap() != this) {
            throw new IllegalArgumentException(
                "Bu kitap kopyası başka bir kitaba ait."
            );
        }

        if (!kopyalar.contains(kopya)) {
            kopyalar.add(kopya);
        }
    }

    public void oduncVer() {
        if (durum != KitapDurumu.MEVCUT) {
            throw new IllegalStateException(
                "Kitap ödünç verilemez. Mevcut durum: " + durum
            );
        }

        durum = KitapDurumu.ODUNC_VERILDI;
    }

    public void teslimAl() {
        if (durum != KitapDurumu.ODUNC_VERILDI) {
            throw new IllegalStateException(
                "Yalnızca ödünç verilmiş kitap teslim alınabilir."
            );
        }

        durum = KitapDurumu.MEVCUT;
    }

    public String kitapBilgisi() {
        return "ADI: " + baslik
             + " | YAZARI: " + yazar
             + " | YAYIN YILI: " + yayinYili
             + " | ISBN: " + isbn
             + " | DURUM: " + durum
             + " | KOPYA SAYISI: " + kopyalar.size();
    }

}//Kitap
