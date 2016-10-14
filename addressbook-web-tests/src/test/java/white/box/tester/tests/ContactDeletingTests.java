package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.UserData;

import java.util.List;

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
    List<UserData> before = app.getContactHelper().getContactList();

    app.getContactHelper().deleteFirstContact();
    app.goTo().gotoHomePage();
    List<UserData> after = app.getContactHelper().getContactList(); // Equals Lists before and after deleting
    Assert.assertEquals(after.size(), before.size() - 1);

    //before.remove(before.size() - 1);
    before.remove(0);
    Assert.assertEquals(before, after);
  }
}
