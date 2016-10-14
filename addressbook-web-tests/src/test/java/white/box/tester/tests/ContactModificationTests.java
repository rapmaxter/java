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

  @Test

  public void testUserModification() {

    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAUser()) {
      app.getContactHelper().createUser(new UserData().withFirstname("Test23").withLastname("Test212").
              withAddress("Test4443").withPhone("5343"));
    }

      app.goTo().gotoHomePage();
    List<UserData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initModification(before.size() - 1);
    UserData user = new UserData().withId(before.get(before.size() - 1).getId()).withFirstname("Test123").withLastname("Test1212").
            withAddress("Test14443").withPhone("15343");
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
