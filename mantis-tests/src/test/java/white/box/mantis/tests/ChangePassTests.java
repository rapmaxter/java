package white.box.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import white.box.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Max on 11/2/2016.
 */
public class ChangePassTests extends TestBase {


  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testPassChange() throws IOException, MessagingException {
    app.changepass().login("administrator","root");
    app.changepass().passreset();
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    findConfirmationLink(mailMessages, "root@localhost");
    }


   private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
   MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
   }


  @AfterMethod(alwaysRun = true)
  public  void  stopMailServer() {
    app.mail().stop();
  }



}

