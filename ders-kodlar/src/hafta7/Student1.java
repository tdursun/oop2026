package hafta7;

public class Student1 {
    private String name;
    int studentNo;

    Student1(String name, int studentNo) {
        this.name = name;
        this.studentNo = studentNo;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
class Program {
    public static void main(String[] args) {
        Student1 s1 = new Student1("Ali", 1001);
        Student1 s3;
        s3=s1;
        Student1 s2 = new Student1("Ali", 1001);
        //s1  ve s2 farklı bellek bölgelerindeki iki aynı Nesneyi işaret ediyor
        // iki nesne içinde aynı isim, aynı no bilgisi var

        //s1.setName("İrem");
        //System.out.println(s1.getName());

        System.out.println(s1 == s2); //false
        System.out.println(s1 == s3); //true
        
        System.out.println(s1.equals(s2)); //false 

        // gizli equals() metodunu kullanıyoruz
        // ancak default hali, aynı adresteki nesneler mi diye kontrol ediyor
    }
}