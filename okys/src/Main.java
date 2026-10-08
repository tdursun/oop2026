public class Main {
    public static void main(String[] args) 
    {
        //ilk kitap ekleniyor
        Kitap kitap1 = new Kitap(
            "9780132350884",
            "Clean Code",
            "Robert C. Martin",
            2008
        );
        
        System.out.println(kitap1.getDurum());
        // MEVCUT
        
        kitap1.oduncVer();
        
        System.out.println(kitap1.getDurum());
        // ODUNC_VERILDI
        
        kitap1.teslimAl();
        
        System.out.println(kitap1.getDurum());
        // MEVCUT
    }
}
