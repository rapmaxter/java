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

    if (app.db().contacts().size() == 0){
      app.goTo().gotoHomePage();
      app.getContactHelper().createUser(new ContactData().withFirstname("Test23").withLastname("Test113").
              withAddress("Test4443"));

    }

      app.goTo().gotoHomePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withFirstname("Test123")
            .withLastname("Test1212")
            .withAddress("Test14443").withMobile("234235").withEmail1("test123");

    app.getContactHelper().modify(contact);
    app.goTo().gotoHomePage();
    assertEquals(app.getContactHelper().count(), before.size());
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
  }


}
