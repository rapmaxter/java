package white.box.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import white.box.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

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
    app.changepass().passreset(); // делаем резет пароля user55

    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, "user55@localhost.localdomain");
    String user_name = "user55";
    String user_password = "wordpass";
    app.changepass().finish(confirmationLink, user_password);
    assertTrue(app.newSession().login(user_name, user_password));
    }


   private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
   MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
     VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
     return regex.getText(mailMessage.text);
   }


  @AfterMethod(alwaysRun = true)
  public  void  stopMailServer() {
    app.mail().stop();
  }



}

