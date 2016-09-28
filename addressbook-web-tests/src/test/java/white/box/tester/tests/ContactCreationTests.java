package white.box.tester.tests;

import org.testng.annotations.Test;
import white.box.tester.model.UserData;

public class ContactCreationTests extends TestBase {


  @Test
  public void user() {

    app.getContactHelper().newUser();
    app.getContactHelper().fillUserField(new UserData("Test1", "Test2", "Test3", "01"));
    app.getContactHelper().submitCreating();
    app.logoutUser();
  }

}