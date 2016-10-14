package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.UserData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void Should_create_user() {

    app.goTo().gotoHomePage();
    List<UserData> before = app.getContactHelper().getContactList();
    UserData user = new UserData().withFirstname("Test23").withLastname("Test113").
            withAddress("Test4443").withPhone("5343");
    app.getContactHelper().createUser(user);
    app.goTo().gotoHomePage();
    List<UserData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (UserData g : after){
      if (g.getId() > max ) {
        max = g.getId();
      }
    }
    user.setId(max);
    before.add(user);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}