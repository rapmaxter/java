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

    if (app.db().contacts().size() == 0){
      app.goTo().gotoHomePage();
      app.getContactHelper().createUser(new ContactData().withFirstname("Test23").withLastname("Test113").
              withAddress("Test4443").withHomephone("5343"));

    }

    app.goTo().gotoHomePage();
    Contacts before = app.db().contacts();
    ContactData deleteContact = before.iterator().next();
    app.getContactHelper().deleteFirstContact(deleteContact);
    app.goTo().gotoHomePage();
    assertEquals(app.getContactHelper().count(), before.size() - 1);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(deleteContact)));


    // assertEquals(after.size(), before.size() - 1);    моя первая проверка
    //Contacts after = app.getContactHelper().all();
  //  assertThat(after, equalTo(before.withOut(deleteContact)));

  }
}
