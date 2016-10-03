package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.UserData;

import java.util.List;

/**
 * Created by Max on 9/19/2016.
 */
public class ContactModificationTests extends TestBase {

  @Test

  public void testUserModification() {

    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAUser()) {
      app.getContactHelper().createUser(new UserData("Test1", "Test2", "Test3", "01"));
    }

      app.getNavigationHelper().gotoHomePage();
    List<UserData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initModification(before.size() - 1);
    app.getContactHelper().contactModification();
    app.getNavigationHelper().gotoHomePage();
    List<UserData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
