package hafta6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// 1. Örnek Nesne Sınıfı
class Ogrenci {
    private int id;
    private String isim;
    private String bolum;

    public Ogrenci(int id, String isim, String bolum) {
        this.id = id;
        this.isim = isim;
        this.bolum = bolum;
    }

    // Getters
    public int getId() { return id; }
    public String getIsim() { return isim; }
    public String getBolum() { return bolum; }

    // CSV formatına dönüştürme kolaylığı için yardımcı metot
    public String toCSV() {
        return id + "," + isim + "," + bolum;
    }

    @Override
    public String toString() {
        return "Ogrenci{id=" + id + ", isim='" + isim + "', bolum='" + bolum + "'}";
    }
}

public class FileService2 {

    // 2. ArrayList'i CSV Dosyasına Yazma Metodu
    public static void csvYaz(String dosyaYolu, ArrayList<Ogrenci> ogrenciler) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dosyaYolu))) {
            // Başlık satırı (Header) ekleme
            bw.write("ID,Isim,Bolum");
            bw.newLine();

            // Verileri satır satır yazma
            for (Ogrenci ogr : ogrenciler) {
                bw.write(ogr.toCSV());
                bw.newLine();
            }
            System.out.println("Veriler başarıyla CSV dosyasına yazıldı.");
        } catch (IOException e) {
            System.err.println("Dosya yazma hatası: " + e.getMessage());
        }
    }

    // 3. CSV Dosyasını Okuyup ArrayList'e Aktarma Metodu
    public static ArrayList<Ogrenci> csvOku(String dosyaYolu) {
        ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
        
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
                if (veriler.length == 3) {
                    int id = Integer.parseInt(veriler[0].trim());
                    String isim = veriler[1].trim();
                    String bolum = veriler[2].trim();

                    // Yeni nesne oluştur ve listeye ekle
                    ogrenciler.add(new Ogrenci(id, isim, bolum));
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
        return ogrenciler;
    }

    // 4. Çalıştırma (Main) Metodu
    public static void main(String[] args) {
        String dosyaYolu = "ogrenciler.csv";

        // Yazılacak örnek veri listesi
        ArrayList<Ogrenci> yazilacakListe = new ArrayList<>();
        yazilacakListe.add(new Ogrenci(1, "Ahmet Yılmaz", "Bilgisayar Müh."));
        yazilacakListe.add(new Ogrenci(2, "Ayşe Demir", "Endüstri Müh."));
        yazilacakListe.add(new Ogrenci(3, "Mehmet Kaya", "Makine Müh."));

        // Dosyaya Yazma İşlemi
        csvYaz(dosyaYolu, yazilacakListe);

        System.out.println("\n--- Dosyadan Okunan Veriler ---");
        
        // Dosyadan Okuma İşlemi
        ArrayList<Ogrenci> okunanListe = csvOku(dosyaYolu);
        for (Ogrenci ogr : okunanListe) {
            System.out.println(ogr);
        }
    }
}
