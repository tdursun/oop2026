package hafta5;
interface A {   
    default void show() {
        System.out.println("A");
    }
    void mesajGoster();

}
        
interface B {
    default void show() { 
        System.out.println("B");    
    }
    void mesajGoster();
}
    
class C implements A, B {   
    @Override 
    public void show() {      
        //A.super.show();
	    //System.out.println("C decides");    
    }
    public void mesajGoster(){
        System.out.println("Mesaj C sınıfında gosteriliyor");
    }
}

public class Main_Interface3 {
    public static void main(String[] args) {
                
        C c1 = new C();
        c1.show();
        c1.mesajGoster();

        //System.out.println("Welcome!"+ kedi.sleep());
        
    }
}