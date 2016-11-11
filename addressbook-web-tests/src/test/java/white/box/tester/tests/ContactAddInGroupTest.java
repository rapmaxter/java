package white.box.tester.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import white.box.tester.model.ContactData;
import white.box.tester.model.Contacts;
import white.box.tester.model.GroupData;
import white.box.tester.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

/**
 * Created by Max on 10/27/2016.
 */
public class ContactAddInGroupTest extends TestBase {

  private ContactData _contact;
  private GroupData _group;

  @BeforeMethod
  public void prepareGroup() {
     Groups groups = app.db().groups();
     if (groups.size() == 0){
         app.goTo().GroupPage();
      GroupData group = new GroupData().withName("test1");
       app.group().create(group);
       _group = group;
       }
    else _group = groups.iterator().next();
  }

  @BeforeMethod
  public void prepareContacts() {
      app.goTo().gotoHomePage();
      ContactData contact = new ContactData().withFirstname("Test23").withLastname("Test113").
              withAddress("Test4443").withHomephone("5343");
           app.getContactHelper().createUser(contact);
      _contact = contact;
  }

    @Test
    public void testContactInGroup(){
      Contacts beforeContacts = app.db().contacts();
      ContactData contact = beforeContacts.iterator().next();

      Groups groups = app.db().groups();
      groups.removeAll(contact.getGroups());
      GroupData group = groups.iterator().next();
      app.goTo().gotoHomePage();
         app.getContactHelper().addContactInGroup(_contact, _group);
      Contacts afterContacts = app.db().contacts();
      ContactData contactWithGroup = afterContacts.iterator().next();

      assertThat(contactWithGroup.getGroups(), equalTo(contact.getGroups().withAdded(group)));

    }
    }







