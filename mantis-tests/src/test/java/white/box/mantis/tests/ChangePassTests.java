package white.box.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Max on 11/2/2016.
 */
public class ChangePassTests extends TestBase {

  @Test
  public void testPassChange(){
    app.changepass().login("administrator","root");
    app.changepass().passreset();

  }
}

