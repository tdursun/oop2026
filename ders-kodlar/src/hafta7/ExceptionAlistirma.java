package hafta7;

import java.io.IOException;

public class ExceptionAlistirma {

    public static void main(String[] args) {

        int a = 10;
        int b = 5;
        int sonuc = -1;
        try {
            int result = a / b;  //    10/0
            sonuc = result;   // bu satıra gelemeyecek
        
        } catch(Exception hata){
            System.out.println("Hata: " + hata.getMessage());
            System.out.println("Hata türü: " + hata.getClass().getName());

            if(hata instanceof ArithmeticException){
                System.out.println("Hata bir Aritmetik Hata türüdür.");
            }else if (hata instanceof IOException){
                System.out.println("Hata bir IOException türüdür.");
            }

        }

        System.out.println("Result: " + sonuc);
        System.out.println("Program continues...");

        String text = "125";

        try {
            int number = Integer.parseInt(text);
            System.out.println(number);
        }
        catch (NumberFormatException e) {
            System.out.println("Text sayı formatında değil!");
        }

        int[] numbers = {10, 20, 30};   //0,1,2
        numbers[0]=45;
        numbers[1]=30;
        numbers[2]= numbers[0]+numbers[1];


        try {
            System.out.println(numbers[3]);
            //....
            //...
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }

        //...
    }
}



/*

*/