package hafta5;
interface NotificationService {
    void send(String message); // Diğer sınıflarda implemente edilecek metod
}

class EmailService implements NotificationService{
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
class OrderService {
    private NotificationService notification;
    public OrderService(NotificationService uyari) {
        this.notification = uyari;
    }
    public void completeOrder() {
        notification.send("Siparis tamamlandi");
    }
}

public class Main_Interface {
    public static void main(String[] args) {
                
        OrderService siparisServisi = new OrderService(new EmailService());
        siparisServisi.completeOrder();
        
    }
}