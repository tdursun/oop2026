package hafta7;

public class Student {

    String name;
    int studentNo;

    public Student(String name, int studentNo) {
        this.name = name;
        this.studentNo = studentNo;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Student other = (Student) obj;

        return (this.studentNo == other.studentNo) && 
               (this.name.equals(other.name));

    }

    @Override
    public String toString() {
        return "Öğrenci No:_ " + studentNo + ", Adı:_ " + name;
    }
    

    public static void main(String[] args) {

        Student s1 = new Student("Ali", 1001);

        Student s2 = new Student("Ali", 1001);

        //s1  ve s2 farklı bellek bölgelerindeki iki aynı Nesneyi işaret ediyor

        System.out.println(s1 == s2);  // false

        System.out.println(s1.equals(s2));  // true

        String metin = new String("Ali");
        Student s5 = null;

        System.out.println(s1.equals(metin));  // false
        System.out.println(s1.equals(s5));  // false

        System.out.println(s1);  
        //hafta7.Student@7ad041f3
        //toStr metodumuzu yazdıktan sonra --> Öğrenci No:_ 1001, Ad:_ Ali
    }
}