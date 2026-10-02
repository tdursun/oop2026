**Online Kütüphane Yönetim Sistemi (OKYS) Senaryo Metni**
1.Tanım
OKYS, üyelerin kitaplara kolayca erişmesini ve kütüphane personelinin süreçleri dijital olarak yönetmesini sağlayan bir platformdur.

**2.Gereksinimler**
2.1.Sistemde iki temel kullanıcı rolü bulunmaktadır: Üye ve Kütüphane Görevlisi. 
2.2.Her kullanıcının sistemde kayıtlı bir benzersiz kullanıcı numarası, adı, e-posta adresi ve şifresi bulunur. 
2.3. Üyeler, sisteme giriş yaptıktan sonra "Kitap Arama" işlemi gerçekleştirebilir, ilgilendikleri kitapları ödünç alabilir ve 
mevcut ödünç aldıkları kitapların süresini uzatabilirler. 

2.4.Kütüphane Görevlisi  sisteme yeni kitaplar ekleyebilir, 
2.5.Kütüphane Görevlisi mevcut kitap bilgilerini güncelleyebilir 
2.6. Kütüphane Görevlisi üyelerin ödünç alma taleplerini onaylayıp takip edebilir.

2.7. Sistemdeki her Kitap; benzersiz bir ISBN numarası, başlık, yazar, yayın yılı ve durum (Ödünç Verilebilir / Ödünç Verildi) bilgilerine sahiptir. 
2.8.Bir kitabın kütüphanede birden fazla fiziksel kopyası (Kitap Kopyası) bulunabilir; her kopyanın kendine ait bir barkod numarası vardır.
2.9 Bir Üye bir kitabı ödünç aldığında, sistemde bir Ödünç Alma kaydı oluşturulur. Bu kayıt; benzersiz bir işlem numarası, ödünç alma tarihi, teslim edilmesi gereken son tarih ve gerçek teslim tarihini içerir. 
2.10.Bir Ödünç Alma kaydı, tam olarak bir Üye ve bir Kitap Kopyası ile doğrudan ilişkilidir. 
2.11.Bir üye tek seferde birden fazla kitap kopyası ödünç alabilir, ancak her bir kopya için ayrı bir Ödünç Alma satırı tutulur.
