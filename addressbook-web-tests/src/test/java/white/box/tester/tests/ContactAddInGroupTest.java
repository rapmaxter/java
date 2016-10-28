package white.box.tester.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import white.box.tester.model.ContactData;
import white.box.tester.model.Contacts;
import white.box.tester.model.GroupData;
import white.box.tester.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Max on 10/27/2016.
 */
public class ContactAddInGroupTest extends TestBase {



  @BeforeMethod
  public void ensurePreconditionsGroups() {
    app.goTo().GroupPage();
    Groups before = app.db().groups();
    if (app.db().groups().size() == 0){
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test1"));
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.size() + 1));
      verifyGroupListInUI();
    }
  }


  @BeforeMethod
  public void ensurePreconditionsContacts() {

    if (app.db().contacts().size() == 0){
      app.goTo().gotoHomePage();
      app.getContactHelper().createUser(new ContactData().withFirstname("Test23").withLastname("Test113").
              withAddress("Test4443").withHomephone("5343"));
    }
  }

    @Test
    public void testContactInGroup (ContactData contact){
           app.goTo().gotoHomePage();
          app.getContactHelper().addContact(contact);

    }
}




