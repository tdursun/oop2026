package hafta6;

public class Main_ErrorHandling {
    public static void main(String[] args) {
                
        Integer x = 127;
        Integer y = 127;
        Integer m = 128;
        Integer n = 128;
        int x1 = 127;
        int y1 = 127;
        int m1 = 128;
        int n1 = 128;
        System.out.println((x==y) +".  ."+(m==n));  //true false
        System.out.println(x.equals(y) +".  ."+(m.equals(n)));  //true true
        System.out.println((x1==y1) +".  ."+(m1==n1));  //true true
    }
}