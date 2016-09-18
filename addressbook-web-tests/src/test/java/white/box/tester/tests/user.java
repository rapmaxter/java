package white.box.tester.tests;

import org.testng.annotations.Test;
import white.box.tester.model.UserData;

public class user extends TestBase {


  @Test
  public void user() {

    app.newUser();
    app.fillUserField(new UserData("Test1", "Test2", "Test3", "01"));
    app.submitCreating();
    app.logoutUser();
  }

}