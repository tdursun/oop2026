package hafta5;
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();

    void sleep() {
        System.out.println("Sleeping...");
    }
}
class Dog extends Animal {
    Dog(String name) { super(name); }

    @Override
    public void makeSound() {
        System.out.println("Hav hav");
    }
}

class Cat extends Animal {
    Cat(String name) { super(name); }

    @Override
    public void makeSound() {
        System.out.println("Miyav!");
    }
}

public class Main_Abstraction {

    public static void main(String[] args) {
        //Animal evcil1 = new Animal();
        
        Cat kedi = new Cat("Minnoş");  //referans tip: Cat, Gerçek tip: Cat
        Animal a = new Cat("kedicik"); //referans tip: Animal, Gerçek tip: Cat

        //referans tip üzerinden erişmek
        a.makeSound();
        a.sleep();

        //gerçek tip üzerinden erişmek
        kedi.makeSound();
        kedi.sleep();
        
        //System.out.println("Welcome!"+ kedi.sleep());
        
    }
}