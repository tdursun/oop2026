public class KutuphaneGorevlisi extends Kullanici {
    private String sicilNo;
    public KutuphaneGorevlisi(
            String id,
            String ad,
            String eposta,
            String sifre,
            String sicilNumarasi) {
        super(id, ad, eposta, sifre);
        this.sicilNo = sicilNumarasi;

    }
    public String getSicilNo() {
        return sicilNo;
    }
    
    public String getInfo(){
        return "Kütüphaneci: " + 
            "\nID        : " + super.getId()+
            "\nAD        : " + super.getAd()+
            "\nEPOSTA    : " + super.getEposta()+
            "\nSicil No  : " + sicilNo;
    }
}
