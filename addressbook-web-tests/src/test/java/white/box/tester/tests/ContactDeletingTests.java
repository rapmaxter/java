package white.box.tester.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.Contacts;
import white.box.tester.model.Groups;
import white.box.tester.model.UserData;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Contacts before = app.getContactHelper().all();
    UserData deleteContact = before.iterator().next();
    app.getContactHelper().deleteFirstContact(deleteContact);
    app.goTo().gotoHomePage();
    Contacts after = app.getContactHelper().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.withOut(deleteContact)));

  }
}
