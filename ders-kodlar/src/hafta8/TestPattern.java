package hafta8;
//OBSERVER DESIGN PATTERN

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int temperature);
}

class PhoneDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("Phone: " + temperature);
    }
}
class ProjectorDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("Projector: " + temperature);
    }
}

//Gözetlenen nesne. Abonelerine değişiklikleri duyuran.
class WeatherStation {
    private List<Observer> abonelerim = new ArrayList<>();
    private int temperature;

    //ABONE KAYDI
    public void addObserver(Observer o) {
        abonelerim.add(o);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        //aboneleri de uyar
        notifyObservers();
    }
    //ABONELERİ UYAR
    private void notifyObservers() {
        for (Observer o : abonelerim)
            o.update(temperature);
    }
}

public class TestPattern {

    public static void main(String[] args) {
        System.out.println("Hafta 8 Uygulama");  
        WeatherStation station = new WeatherStation();

        Observer phone1 = new PhoneDisplay();
        Observer phone2 = new PhoneDisplay();
        Observer phone3 = new PhoneDisplay();
        Observer projector = new ProjectorDisplay();

        station.addObserver(phone1);
        station.addObserver(phone2);
        
        station.setTemperature(25);

        station.addObserver(projector);
        station.setTemperature(30);

        station.addObserver(phone3);
        station.setTemperature(50);
        
    }
}