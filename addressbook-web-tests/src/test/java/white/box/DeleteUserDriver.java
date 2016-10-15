package white.box;

import org.testng.annotations.Test;
import white.box.tester.tests.TestBase;

/**
 * Created by Max on 9/19/2016.
 */
public class DeleteUserDriver extends TestBase {

  @Test
  public void testDeleteUser () {

    app.goTo().gotoHomePage();
    //app.getContactHelper().initModificationById();
    app.getContactHelper().deleteUser1();
   //  app.getContactHelper().approveAllarm(); // команда подтверждения "ОК" высплывающего окна
  }
}
