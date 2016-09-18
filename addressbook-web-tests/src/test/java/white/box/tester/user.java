package white.box.tester;

import org.testng.annotations.Test;

public class user extends TestBase {


  @Test
  public void user() {

    newUser();
    fillUserField(new testData("Test1", "Test2", "Test3", "01"));
    submitCreating();
    logoutUser();
  }

}

