package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.UserData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {


  @Test
  public void Should_create_user() {

    app.goTo().gotoHomePage();
    Set<UserData> before = app.getContactHelper().all();
    UserData user = new UserData().withFirstname("Test23").withLastname("Test113").
            withAddress("Test4443").withPhone("5343");
    app.getContactHelper().createUser(user);
    app.goTo().gotoHomePage();
    Set<UserData> after = app.getContactHelper().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt());
    before.add(user);
    Assert.assertEquals(before, after);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
      }
    }



