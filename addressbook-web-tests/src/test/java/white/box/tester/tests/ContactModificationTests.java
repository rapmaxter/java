package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.UserData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Max on 9/19/2016.
 */
public class ContactModificationTests extends TestBase {

  @Test (enabled = false)

  public void testUserModification() {

    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAUser()) {
      app.getContactHelper().createUser(new UserData("Test1", "Test2", "Test3", "01"));
    }

      app.goTo().gotoHomePage();
    List<UserData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initModification(before.size() - 1);
    UserData user = new UserData(before.get(before.size() - 1).getId(), "Test23", "Test212", "Test31", "0133");
    app.getContactHelper().fillUserField(user);
    app.getContactHelper().submitCreating();
    app.goTo().gotoHomePage();
    List<UserData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(user);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
