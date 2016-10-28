package white.box.tester.tests;

import org.testng.annotations.Test;
import white.box.tester.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Max on 10/28/2016.
 */
public class ContactEmailTest extends TestBase {


  @Test
  public void testContactEmails() {
    app.goTo().gotoHomePage();
    ContactData contact = app.getContactHelper().all().iterator().next();
    ContactData contactInfoFromEditForm = app.getContactHelper().infoFormEditForm(contact);


    assertThat(contact.getAllemails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Stream.of(contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
  }

}
