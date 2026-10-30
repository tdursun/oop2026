import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileService {
        // 2. ArrayList'i CSV Dosyasına Yazma Metodu
    public static void csvYaz(String dosyaYolu, List<Kitap> kitaplar) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dosyaYolu))) {
            // Başlık satırı (Header) ekleme
            bw.write("ISBN,BASLIK,YAZAR,YAYINYILI");
            bw.newLine();

            // Verileri satır satır yazma
            for (Kitap ktp : kitaplar) {
                bw.write(ktp.toCSV());
                bw.newLine();
            }
            System.out.println("Veriler başarıyla CSV dosyasına yazıldı.");
        } catch (IOException e) {
            System.err.println("Dosya yazma hatası: " + e.getMessage());
        }
    }

    // 3. CSV Dosyasını Okuyup ArrayList'e Aktarma Metodu
    public static ArrayList<Kitap> csvOku(String dosyaYolu) {
        ArrayList<Kitap> kitaplar = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            boolean ilkSatir = true;

            while ((satir = br.readLine()) != null) {
                // Başlık satırını atla
                if (ilkSatir) {
                    ilkSatir = false;
                    continue;
                }

                // Virgül ile verileri ayır
                String[] veriler = satir.split(",");
                if (veriler.length == 4) {
                    String isbn=veriler[0].trim();
                    String baslik=veriler[1].trim();
                    String yazar=veriler[2].trim();
                    int yayinYili=Integer.parseInt(veriler[3].trim());
                    // Yeni nesne oluştur ve listeye ekle
                    kitaplar.add(new Kitap(isbn,baslik,yazar,yayinYili));
                }else{
                    //do nothing. Satir bozukmuş, atla
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
        return kitaplar;
    }
    
}

