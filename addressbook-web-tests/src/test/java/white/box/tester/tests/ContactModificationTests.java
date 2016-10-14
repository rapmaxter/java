package white.box.tester.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.Contacts;
import white.box.tester.model.UserData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Max on 9/19/2016.
 */
public class ContactModificationTests extends TestBase {

  @Test (enabled = false)

  public void testUserModification() {

    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAUser()) {
      app.getContactHelper().createUser(new UserData().withFirstname("Test23").withLastname("Test212").
              withAddress("Test4443").withPhone("5343"));
    }

      app.goTo().gotoHomePage();
    Contacts before = app.getContactHelper().all();
    UserData modifiedContact = before.iterator().next();
        UserData user = new UserData().withId(modifiedContact.getId()).withFirstname("Test123").withLastname("Test1212").
            withAddress("Test14443").withPhone("15343");

    app.getContactHelper().modify(user);

    app.goTo().gotoHomePage();
    Contacts after = app.getContactHelper().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(user)));
  }


}
