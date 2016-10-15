package white.box.tester.tests;


import org.testng.annotations.Test;
import white.box.tester.model.ContactData;
import white.box.tester.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test
  public void Should_create_user() {

    app.goTo().gotoHomePage();
    Contacts before = app.getContactHelper().all();
    ContactData contact = new ContactData().withFirstname("Test23").withLastname("Test113").
            withAddress("Test4443").withHomephone("5343");
    app.getContactHelper().createUser(contact);
    app.goTo().gotoHomePage();
    Contacts after = app.getContactHelper().all();
    assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded
            (contact.withId(after.stream().
                    mapToInt((u) -> u.getId()).max().getAsInt()))));
      }
    }



