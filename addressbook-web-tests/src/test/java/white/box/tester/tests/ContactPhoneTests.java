package white.box.tester.tests;


import org.testng.annotations.Test;

import white.box.tester.model.ContactData;


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Max on 10/15/2016.
 */
public class ContactPhoneTests extends TestBase  {


  @Test
  public void testPhonesContacts() {
    app.goTo().gotoHomePage();
    ContactData contact = app.getContactHelper().all().iterator().next();
    ContactData contactInfoFormEditForm = app.getContactHelper().infoFormEditForm(contact);

    assertThat(contact.getAllphones(), equalTo(mergePhones(contactInfoFormEditForm)));

  }

  private String mergePhones(ContactData contact){
    return Stream.of(contact.getHomephone(), contact.getMobile(), contact.getWorkphone())
            .filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests :: cleanedPhone)
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedPhone (String phone) {

    return phone.replaceAll("\\s", "")
            .replaceAll("[-()]" , "");
  }

}
