package white.box.tester.tests;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import white.box.tester.model.ContactData;
import white.box.tester.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    List<ContactData> groups = (List<ContactData>) xStream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList())
            .iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testsContactCreation(ContactData contact) {

    app.goTo().gotoHomePage();
    Contacts before = app.db().contacts();
  //  File photo = new File("src/test/resources/Feature.png");
    app.getContactHelper().createUser(contact);
    app.goTo().gotoHomePage();
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded
            (contact.withId(after.stream().
                    mapToInt((u) -> u.getId()).max().getAsInt()))));
  }


  @Test (enabled = false)
  public void Should_create_user_BAD() {

    app.goTo().gotoHomePage();
    Contacts before = app.getContactHelper().all();
    File photo = new File("src/test/resources/Feature.png");
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



