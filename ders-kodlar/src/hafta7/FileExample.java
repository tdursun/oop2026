package hafta7;

import java.io.*;
import java.util.Scanner;

public class FileExample {

    public static void readFile() {

        try {
            String filePath = "oop2026/Kutuphane29Mayis.csv";
            FileReader file = new FileReader(filePath);
            System.out.println("File opened!");
            System.out.println(file.readAllAsString());
        }
        catch (IOException e) {
            System.out.println("File error! :"+ e.getMessage());
        }
    }

    public static void dosyaOku(String dosyaAdresi) throws Exception{
            FileReader file = new FileReader(dosyaAdresi);
            System.out.println("File opened!");
            System.out.println(file.readAllAsString());
    }

    public static void main(String[] args){

        readFile();
        
        System.out.println("Şimdi ikinci metodla okuyoruz...");

        try {
            dosyaOku("oop2026/Kutuphane29Mayis.csv3");
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Dosya okuma hatası: " + e.getMessage());

            //e.printStackTrace();
        }
        System.out.println("Program continues...");

    }
}