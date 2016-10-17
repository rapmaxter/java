package white.box.tester.tests;


import org.testng.annotations.Test;
import white.box.tester.model.ContactData;
import white.box.tester.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test
  public void Should_create_user() {

    app.goTo().gotoHomePage();
    Contacts before = app.getContactHelper().all();
    File photo = new File("src/test/resources/Featute.png");
    ContactData contact = new ContactData().withFirstname("Test7423").withLastname("Test113").
            withAddress("Test4443").withHomephone("5343").withPhoto(photo);
    app.getContactHelper().createUser(contact);
    app.goTo().gotoHomePage();
    Contacts after = app.getContactHelper().all();
    assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded
            (contact.withId(after.stream().
                    mapToInt((u) -> u.getId()).max().getAsInt()))));
      }
    }



