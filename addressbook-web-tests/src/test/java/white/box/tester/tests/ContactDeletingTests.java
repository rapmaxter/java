package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.UserData;

import java.util.List;
import java.util.Set;

/**
 * Created by Max on 9/19/2016.
 */
public class ContactDeletingTests extends TestBase {

  @Test
  public void testDeleteUser() {

    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAUser()) {
      app.getContactHelper().createUser(new UserData().withFirstname("Test23").withLastname("Test113").
              withAddress("Test4443").withPhone("5343"));

    }

    app.goTo().gotoHomePage();
    Set<UserData> before = app.getContactHelper().all();
    UserData deleteContact = before.iterator().next();
    app.getContactHelper().deleteFirstContact(deleteContact);
    app.goTo().gotoHomePage();
            Set<UserData> after = app.getContactHelper().all(); // Equals Lists before and after deleting
    Assert.assertEquals(after.size(), before.size() - 1);


    before.remove(deleteContact);
    Assert.assertEquals(before, after);
  }
}
