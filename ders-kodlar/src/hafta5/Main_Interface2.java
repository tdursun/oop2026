package hafta5;
import java.util.ArrayList;
import java.util.List;

interface CargoService {
    void gonder(String orderId,String address);
    String izle(String trackingNumber);
}

class YurticiCargo implements CargoService {
    public void gonder(String orderId, String address) {
        System.out.println("Kargonuz Yurtici Kargo ile gonderiliyor...");
        //Yurtiçi Kargo firmasının API’larını çağıran kodlar
        //...
    }   
    public String izle(String trackingNumber) {
        return "IN_TRANSIT";
    }
    public double fiyatHesapla(double agirlik){
        return agirlik*1.25;
    }
}
class DHLCargo implements CargoService {
    public void gonder(String orderId, String address) {
        System.out.println("Kardelen: Kargonuz DHL Kargo ile gonderiliyor...");
        //DHL Kargo firmasının API’larını çağıran kodlar
        //...
    }   
    public String izle(String trackingNumber) {
        return "IN_TRANSIT";
    }
}
class ArasCargo implements CargoService {
    public void gonder(String orderId, String address) {
        System.out.println("Kargonuz Aras Kargo ile gonderiliyor...");
        //Aras Kargo firmasının API’larını çağıran kodlar
        //...
    }   
    public String izle(String trackingNumber) {
        return "IN_TRANSIT";
    }
}
/**
 * SİPARİŞ SERVİSİ
 * SiparisService
 */
class SiparisService {
    //private CargoService cargo;
    private List<CargoService> tanimliKargolar = new ArrayList<>();
    private CargoService tercihEdilenKargo;
    
    SiparisService(List<CargoService> kargolar) {
        this.tanimliKargolar = kargolar;
    }
    public void sendOrder(String orderId, String address) {

        /*if(cargo instanceof YurticiCargo){
            double fiyat = ((YurticiCargo)cargo).fiyatHesapla(4);
            System.out.println("Kargonuzun maliyeti : "+ fiyat);
        }*/
        tercihEdilenKargo.gonder(orderId, address);
    }

    public String kargomNerede(String kargoNo){
        return tercihEdilenKargo.izle(kargoNo);
    }
    
    public void setTercihEdilenKargo(CargoService secilen){
        this.tercihEdilenKargo = secilen;
    }
    
}

public class Main_Interface2 {
    public static void main(String[] args) {
                
        YurticiCargo yurticiCargo = new YurticiCargo();
        DHLCargo dhlCargo = new DHLCargo();        
        ArasCargo arasCargo = new ArasCargo();
        List<CargoService> firmalar = new ArrayList<>();
        firmalar.add(yurticiCargo);
        firmalar.add(arasCargo);
        firmalar.add(dhlCargo);


        SiparisService siparisServisi = new SiparisService(firmalar);
        //Müşteriye sorduk, Hangi Kargoyu tercih ettiğini
        //Müşteri seçimini yaptı
        siparisServisi.setTercihEdilenKargo(dhlCargo);
        
        siparisServisi.sendOrder("123", "Elmali Kent Kampusu, Umraniye/ISTANBUL");
        
    }
}