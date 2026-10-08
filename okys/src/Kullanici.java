public class Kullanici {

    private final String id;
    private final String ad;
    private final String eposta;
    private final String sifre;

    public Kullanici(String id, String ad, String eposta, String sifre) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Kullanıcı numarası boş olamaz.");
        }
        if (ad == null || ad.isBlank()) {
            throw new IllegalArgumentException("Ad boş olamaz.");
        }
        if (eposta == null || eposta.isBlank()) {
            throw new IllegalArgumentException("E-posta boş olamaz.");
        }
        if (sifre == null || sifre.isBlank()) {
            throw new IllegalArgumentException("Şifre boş olamaz.");
        }

        this.id = id;
        this.ad = ad;
        this.eposta = eposta;
        this.sifre = sifre;
    }

    public String getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getEposta() {
        return eposta;
    }

    public String getSifre() {
        return sifre;
    }
}
