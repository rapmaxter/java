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
public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification() {

    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAUser()) {
      app.getContactHelper().createUser(new ContactData().withFirstname("Test23").withLastname("Test212").
              withAddress("Test4443").withHomephone("15343"));
    }

      app.goTo().gotoHomePage();
    Contacts before = app.getContactHelper().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Test123").withLastname("Test1212").
            withAddress("Test14443").withHomephone("15343");

    app.getContactHelper().modify(contact);

    app.goTo().gotoHomePage();
    Contacts after = app.getContactHelper().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
  }


}
