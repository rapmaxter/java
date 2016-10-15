package white.box.tester.tests;

import org.testng.annotations.Test;
import white.box.tester.model.ContactData;
import white.box.tester.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Max on 9/19/2016.
 */
public class ContactDeletingTests extends TestBase {

  @Test
  public void testDeleteContact() {

    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAUser()) {
      app.getContactHelper().createUser(new ContactData().withFirstname("Test23").withLastname("Test113").
              withAddress("Test4443").withHomephone("5343"));

    }

    app.goTo().gotoHomePage();
    Contacts before = app.getContactHelper().all();
    ContactData deleteContact = before.iterator().next();
    app.getContactHelper().deleteFirstContact(deleteContact);
    app.goTo().gotoHomePage();
    Contacts after = app.getContactHelper().all();
    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.withOut(deleteContact)));

  }
}
