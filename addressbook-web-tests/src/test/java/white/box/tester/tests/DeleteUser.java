package white.box.tester.tests;

import org.testng.annotations.Test;
import white.box.tester.model.UserData;

/**
 * Created by Max on 9/19/2016.
 */
public class DeleteUser extends TestBase {

  @Test
  public void testDeleteUser() {

    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAUser()) {
       app.getContactHelper().createUser(new UserData("Test1", "Test2", "Test3", "01"));

      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().initModification();
      app.getContactHelper().deleteUser();
    }
  }
}