package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.UserData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test (enabled = false)
  public void user() {

    app.getNavigationHelper().gotoHomePage();
    List<UserData> before = app.getContactHelper().getContactList();
    UserData user = new UserData("Test23", "Test212", "Test31", "0133");
    app.getContactHelper().createUser(user);
    app.getNavigationHelper().gotoHomePage();
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