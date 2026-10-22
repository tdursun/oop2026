package hafta5;
interface A {   
    default void show() {
        System.out.println("A");
    }
}
        
interface B {
    default void show() { 
        System.out.println("B");    
    }
}
    
class C implements A, B {    
    @Override public void show() {      
        A.super.show();
	    System.out.println("C decides");    
    }
}

public class Main_Interface3 {
    public static void main(String[] args) {
                
        C c1 = new C();
        c1.show();

        //System.out.println("Welcome!"+ kedi.sleep());
        
    }
}