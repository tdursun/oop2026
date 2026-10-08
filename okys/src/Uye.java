import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Uye extends Kullanici {

    private final List<OduncAlma> oduncAlmalar = new ArrayList<>();

    public Uye(String id, String ad, String eposta, String sifre) {
        super(id, ad, eposta, sifre);
    }

    public List<OduncAlma> getOduncAlmalar() {
        return Collections.unmodifiableList(oduncAlmalar);
    }

    public void oduncAlmaEkle(OduncAlma oduncAlma) {
        if (oduncAlma == null || oduncAlma.getUye() != this) {
            throw new IllegalArgumentException(
                "Ödünç alma kaydı bu üyeye ait olmalıdır."
            );
        }
        if (!oduncAlmalar.contains(oduncAlma)) {
            oduncAlmalar.add(oduncAlma);
        }
    }
}
