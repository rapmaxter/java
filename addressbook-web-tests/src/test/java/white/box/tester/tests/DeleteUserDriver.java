package white.box.tester.tests;

import org.testng.annotations.Test;

/**
 * Created by Max on 9/19/2016.
 */
public class DeleteUserDriver extends TestBase {

  @Test
  public void testDeleteUser () {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initUser();
    app.getContactHelper().deleteUser1();
    app.getContactHelper().approveAllarm(); // команда подтверждения "ОК" высплывающего окна
  }
}
