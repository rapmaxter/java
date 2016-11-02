package white.box.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Max on 11/2/2016.
 */
public class RegistrationTests  extends TestBase{

  @Test
  public void testRegistration(){
    app.registration().start("user1","user1@localhost.localdomain");


  }
}