/**
 * import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;
import jakarta.inject.Inject;
import java.io.File;
import org.apache.commons.mail.EmailAttachment;

public class EmailerService {
  @Inject MailerClient mailerClient;

  public void sendEmail() {
    String cid = "1234";
    Email email = new Email()
      .setSubject("Test email")
      .setFrom("Mister FROM <29MayisKutuphane@email.com>")
      .addTo("Miss TO <tdursun@gmail.com>")
      // adds attachment
      .addAttachment("attachment.pdf", new File("/some/path/attachment.pdf"))
      // adds inline attachment from byte array
      .addAttachment("data.txt", "data".getBytes(), "text/plain", "Simple data", EmailAttachment.INLINE)
      // adds cid attachment
      .addAttachment("image.jpg", new File("/some/path/image.jpg"), cid)
      // sends text, HTML or both...
      .setBodyText("A text message")
      .setBodyHtml("<html><body><p>An <b>html</b> message with cid <img src=\"cid:" + cid + "\"></p></body></html>");
    mailerClient.send(email);
  }
}
  */
/*
play.mailer {
  host = "sandbox.smtp.mailtrap.io"
  port = 2525
  ssl = no
  tls = yes
  user = "9d34d3b5e27f71"
  password = "e198a179d3a634"
}
   */

/**
 * 
 * import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) {
        final String username = "sizin_gmail@gmail.com";
        final String password = "uygulama_sifreniz"; // Gmail Uygulama Şifresi

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "://gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("alici_eposta@example.com")
            );
            message.setSubject("Java ile Ücretsiz Mail Gönderimi");
            message.setText("Merhaba, bu e-posta Java ve Gmail SMTP kullanılarak gönderilmiştir.");

            Transport.send(message);
            System.out.println("E-posta başarıyla gönderildi!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
 * 

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsGonderici {
    // Twilio panelinizden alacağınız bilgiler:
    public static final String ACCOUNT_SID = "ACxxxxxxxxxxxxxxxxxxxxxxxx";
    public static final String AUTH_TOKEN = "your_auth_token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber("+905XXXXXXXXX"), // Alıcı Telefon Numarası
                new PhoneNumber("+1XXXXXXXXXX"),  // Twilio'dan aldığınız ücretsiz numara
                "Merhaba, bu Java uygulamasından gönderilen bir test mesajıdır!"
        ).create();

        System.out.println("Mesaj ID'si: " + message.getSid());
    }
}




import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class Example {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                              .creator(new com.twilio.type.PhoneNumber("+5571981265131"),
                                  new com.twilio.type.PhoneNumber("+15005550006"),
                                  "All in the game, yo")
                              .create();

        System.out.println(message.getBody());
    }
}



 */