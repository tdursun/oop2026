import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KitapKopyasi {

    private final String barkod;
    private final Kitap kitap;
    private KitapDurumu durum;
    private final List<OduncKaydi> oduncAlmalar = new ArrayList<>();

    // Constructor
    public KitapKopyasi(String barkod, Kitap kitap) {

        if (barkod == null || barkod.isBlank()) {
            throw new IllegalArgumentException("Barkod boş olamaz.");
        }

        if (kitap == null) {
            throw new IllegalArgumentException("Kitap bilgisi boş olamaz.");
        }

        this.barkod = barkod;
        this.kitap = kitap;

        // Yeni oluşturulan kopyanın durumu başlangıçta rafta mevcut yapılır
        this.durum = KitapDurumu.MEVCUT;

        // Kitap --KitapKopyasi ilişkisini kur
        kitap.kitapKopyasiEkle(this);
    }

    // Getter metotları

    public String getBarkod() {
        return barkod;
    }

    public Kitap getKitap() {
        return kitap;
    }

    public KitapDurumu getDurum() {
        return durum;
    }

    public List<OduncKaydi> getOduncAlmalar() {
        return Collections.unmodifiableList(oduncAlmalar);
    }

    public void oduncAlmaEkle(OduncKaydi oduncAlma) {
        if (oduncAlma == null || oduncAlma.getKitapKopyasi() != this) {
            throw new IllegalArgumentException("Ödünç alma kaydı bu kitap kopyasına ait olmalıdır.");
        }
        if (!oduncAlmalar.contains(oduncAlma)) {
            oduncAlmalar.add(oduncAlma);
        }
    }

    // Davranış metotları

    public void oduncVer() {

        if (durum != KitapDurumu.MEVCUT) {
            throw new IllegalStateException("Kitap kopyası ödünç verilemez. " + "Mevcut durum: " + durum);
        }

        durum = KitapDurumu.ODUNC_VERILDI;
    }

    public void teslimAl() {

        if (durum != KitapDurumu.ODUNC_VERILDI) {
            throw new IllegalStateException("Bu kitap kopyası ödünç verilmiş durumda değil.");
        }

        durum = KitapDurumu.MEVCUT;
    }

    public void kayipBildir() {

        if (durum == KitapDurumu.ODUNC_VERILDI ||
            durum == KitapDurumu.MEVCUT) {

            durum = KitapDurumu.KAYIP;
        }
    }

    public String kopyaBilgisi() {

        return "BARKOD: " + barkod +
               " | KİTAP: " + kitap.getBaslik() +
               " | ISBN: " + kitap.getIsbn() +
               " | DURUM: " + durum;
    }
}
