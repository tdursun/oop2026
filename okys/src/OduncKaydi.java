import java.time.LocalDate;

public class OduncKaydi {

    private final String islemNo;
    private final LocalDate oduncTarihi;
    private final LocalDate sonTeslimTarihi;
    private LocalDate teslimTarihi;
    private final Uye kimde;
    private final KitapKopyasi kitapKopyasi;

    public OduncKaydi(
            String islemNo,
            LocalDate oduncTarihi,
            LocalDate sonTeslimTarihi,
            LocalDate teslimTarihi,
            Uye kim,
            KitapKopyasi kitapKopyasi) {
        if (islemNo == null || islemNo.isBlank()) {
            throw new IllegalArgumentException("İşlem numarası boş olamaz.");
        }
        if (oduncTarihi == null || sonTeslimTarihi == null) {
            throw new IllegalArgumentException("Ödünç ve son teslim tarihleri boş olamaz.");
        }
        if (sonTeslimTarihi.isBefore(oduncTarihi)) {
            throw new IllegalArgumentException(
                "Son teslim tarihi ödünç tarihinden önce olamaz."
            );
        }
        if (teslimTarihi != null && teslimTarihi.isBefore(oduncTarihi)) {
            throw new IllegalArgumentException(
                "Teslim tarihi ödünç tarihinden önce olamaz."
            );
        }
        if (kim == null || kitapKopyasi == null) {
            throw new IllegalArgumentException(
                "Üye ve kitap kopyası boş olamaz."
            );
        }

        this.islemNo = islemNo;
        this.oduncTarihi = oduncTarihi;
        this.sonTeslimTarihi = sonTeslimTarihi;
        this.teslimTarihi = teslimTarihi;
        this.kimde = kim;
        this.kitapKopyasi = kitapKopyasi;

        if (teslimTarihi == null) {
            kitapKopyasi.oduncVer();
        }
        kimde.oduncAlmaEkle(this);
        kitapKopyasi.oduncAlmaEkle(this);
    }

    public String getIslemNo() {
        return islemNo;
    }

    public LocalDate getOduncTarihi() {
        return oduncTarihi;
    }

    public LocalDate getSonTeslimTarihi() {
        return sonTeslimTarihi;
    }

    public LocalDate getTeslimTarihi() {
        return teslimTarihi;
    }

    public Uye getKimde() {
        return kimde;
    }

    public KitapKopyasi getKitapKopyasi() {
        return kitapKopyasi;
    }

    public void teslimEt(LocalDate teslimTarihi) {
        if (teslimTarihi == null || teslimTarihi.isBefore(oduncTarihi)) {
            throw new IllegalArgumentException(
                "Geçerli bir teslim tarihi girilmelidir."
            );
        }
        if (this.teslimTarihi != null) {
            throw new IllegalStateException("Bu ödünç kaydı zaten teslim edilmiş.");
        }
        kitapKopyasi.teslimAl();
        this.teslimTarihi = teslimTarihi;
    }
    public String oduncBilgisi() {

        return "\tISLEM NO: " + islemNo +
               " | ÜYE: " + kimde.getAd() +
               " | ÖDÜNÇ ALMA TARİHİ : " + oduncTarihi +
               " | TESLİM TARİHİ: " + sonTeslimTarihi;
    }
}
