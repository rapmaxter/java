package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.UserData;

import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void user() {

    app.getNavigationHelper().gotoHomePage();
    List<UserData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createUser(new UserData("Test1", "Test2", "Test3", "01"));
    app.getNavigationHelper().gotoHomePage();
    List<UserData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


  }

}