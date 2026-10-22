package hafta5;
interface CargoService {
    void ship(String orderId,String address);
    String track(String trackingNumber);
}
class YurticiCargo implements CargoService {
    public void ship(String orderId, String address) {
        System.out.println("Kargonuz Yurtici Kargo ile gonderiliyor...");
        //Yurtiçi Kargo firmasının API’larını çağıran kodlar
        //...
    }   
    public String track(String trackingNumber) {
        return "IN_TRANSIT";
    }
}

class SiparisService {
    private CargoService cargo;
    public SiparisService(CargoService cargo) {
        this.cargo = cargo;
    }
    public void sendOrder(String orderId, String address) {
        cargo.ship(orderId, address);
    }
}


public class Main_Interface2 {
    public static void main(String[] args) {
                
        YurticiCargo yurticiCargo = new YurticiCargo();
        SiparisService siparisServisi = new SiparisService(yurticiCargo);

        siparisServisi.sendOrder("123", "Elmali Kent Kampusu, Umraniye/ISTANBUL");
        
    }
}