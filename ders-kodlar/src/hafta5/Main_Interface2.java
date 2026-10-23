package hafta5;
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
class SiparisService {
    private CargoService cargo;
    SiparisService(CargoService cargo) {
        this.cargo = cargo;
    }
    public void sendOrder(String orderId, String address) {
        if(cargo instanceof YurticiCargo){
            double fiyat = ((YurticiCargo)cargo).fiyatHesapla(4);
            System.out.println("Kargonuzun maliyeti : "+ fiyat);
        }
        cargo.gonder(orderId, address);
    }

    public String kargomNerede(String kargoNo){
        return cargo.izle(kargoNo);
    }
}


public class Main_Interface2 {
    public static void main(String[] args) {
                
        YurticiCargo yurticiCargo = new YurticiCargo();
        DHLCargo dhlCargo = new DHLCargo();        
        ArasCargo arasCargo = new ArasCargo();

        SiparisService siparisServisi = new SiparisService(yurticiCargo);

        siparisServisi.sendOrder("123", "Elmali Kent Kampusu, Umraniye/ISTANBUL");
        
    }
}