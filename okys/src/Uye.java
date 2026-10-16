import java.util.ArrayList;
import java.util.List;

public class Uye extends Kullanici {

    private String ilgiAlani;
    private final List<OduncKaydi> oduncAlmalar = new ArrayList<>();

    public Uye(String id, String ad, String eposta, String sifre, String interests) {
        super(id, ad, eposta, sifre);
        this.ilgiAlani = interests;
    }

    public List<OduncKaydi> getOduncAlmalar() {
        return oduncAlmalar;
    }

    public void oduncAlmaEkle(OduncKaydi oduncAlma) {
        if (oduncAlma == null || oduncAlma.getKimde() != this) {
            throw new IllegalArgumentException("Ödünç alma kaydı bu üyeye ait olmalıdır.");
        }
        if (!oduncAlmalar.contains(oduncAlma)) {
            oduncAlmalar.add(oduncAlma);
        }
    }
    public String getIlgiAlani() {
        return ilgiAlani;
    }
    public void bilgiPrintEt(){
        System.out.println("Üye: " + 
            "\nID        : " + super.getId()+
            "\nAD        : " + super.getAd()+
            "\nEPOSTA    : " + super.getEposta()+
            "\nilgi Alanı: " + ilgiAlani
        );
    }

}
