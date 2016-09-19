package white.box.tester.tests;

import org.testng.annotations.Test;

/**
 * Created by Max on 9/19/2016.
 */
public class DeleteUser extends TestBase {

  @Test
  public void testDeleteUser () {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initModification();
    app.getContactHelper().deleteUser();
  }
}
