package hafta5;
import java.util.ArrayList;

interface NotificationService {
    void send(String message); // Diğer sınıflarda implemente edilecek metod

}

class EmailService implements NotificationService{
    public void send(String message) {
        //Müşteriye email ile uyarı gönderme kodları olacak
        //mesaj, email adresi
        //....getContactInfo()
        System.out.println("Email: " + message);
    }
}
class SMSService implements NotificationService{
    public void send(String message) {
        //Müşteriye SMS ile uyarı gönderme kodları olacak
        //mesaj, telefonNo
        System.out.println("SMS: " + message);
    }
}

class OrderService {
    private NotificationService notification;
    public OrderService(NotificationService uyariServisi) {
        this.notification = uyariServisi;
    }
    //public OrderService(List<NotificationService> uyariServisLeri) {
    //    this.notification = uyariServisi;
    //}

    public void completeOrder() {
        //musteri tercihlerine bak
        //hangi tip uyari yontemlerini kabul etmiş
        //sonra listemdeki uyarı yontemlerinden ilgili olanlar ,le mesaj gonder
        notification.send("Siparis tamamlandi");
    }
}

public class Main_Interface {
    public static void main(String[] args) {
        EmailService es = new EmailService();
        SMSService sms = new SMSService();
        OrderService siparisServisi = new OrderService(es);
        siparisServisi.completeOrder();
        siparisServisi.completeOrder();
        siparisServisi.completeOrder();
        
    }
}