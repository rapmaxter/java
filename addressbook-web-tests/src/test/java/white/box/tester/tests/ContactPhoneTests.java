package white.box.tester.tests;


import org.testng.annotations.Test;

import white.box.tester.model.ContactData;


import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Max on 10/15/2016.
 */
public class ContactPhoneTests extends TestBase  {


  @Test
  public void testContactPhones() {
    app.goTo().gotoHomePage();
    ContactData contact = app.getContactHelper().all().iterator().next();
    ContactData contactInfoFormEditForm = app.getContactHelper().infoFormEditForm(contact);

    assertThat(contact.getAllphones(), equalTo(mergePhones(contactInfoFormEditForm)));
    assertThat(contact.getAllemails(), equalTo(mergeEmail(contactInfoFormEditForm)));

    assertThat(contact.getAddress(), equalTo(contactInfoFormEditForm.getAddress()));

  }

  private String mergeEmail(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }


  private String mergePhones(ContactData contact){
    return Arrays.asList(contact.getHomephone(), contact.getMobile(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests :: cleanedPhone)
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedPhone (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]" , "");
  }

}
