package hafta5;
abstract class Animal {
    String name;

    Animal(String name) {//constructor
        this.name = name;
    }

    abstract void makeSound();

    void sleep() {
        System.out.println("Sleeping...");
    }
}
/**
 * DOg sınıfıç Animal sınıfndan türüyor....
 * 
 */
class Dog extends Animal {
    Dog(String name) { super(name); }

    @Override
    public void makeSound() {
        System.out.println("Hav hav!");
    }
}

class Cat extends Animal {
    Cat(String name) { super(name); }

    @Override
    public void makeSound() {
        System.out.println("Miyav!");
    }
    // atası olan Animal sınıfında yok. Cat. sınıfına özel bir davranış
    public void tirmala(){
        System.out.println("Tırmaliyorum....");
    }
}

public class Main_Abstraction {

    public static void main(String[] args) {
        //Animal evcil1 = new Animal();
        
        Cat kedi = new Cat("Minnoş");  //referans tip: Cat, Gerçek tip: Cat
        
        Animal a = new Cat("Kedicik"); //referans tip: Animal, Gerçek tip: Cat
        Animal b = new Dog("Dobby"); //referans tip: Animal, Gerçek tip: Dog

        //referans tip üzerinden erişmek
        a.makeSound(); //miyav
        a.sleep();
        
        if ( b instanceof Cat){
            ((Cat)b).tirmala();
        }

        //gerçek tip üzerinden erişmek
        kedi.makeSound();
        kedi.sleep();

        b.makeSound();
        
        //System.out.println("Welcome!"+ kedi.sleep());
        
    }
}