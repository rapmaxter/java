package white.box.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.mantis.appmanager.HttpSession;

import java.io.IOException;

/**
 * Created by Max on 10/31/2016.
 */
public class LoginTests extends TestBase {
  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    Assert.assertTrue(session.login("administrator", "root1"));
    Assert.assertTrue(session.isLoggedInAs("administrator"));
  }
}
