package white.box.tester.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.Contacts;
import white.box.tester.model.UserData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {


  @Test
  public void Should_create_user() {

    app.goTo().gotoHomePage();
    Contacts before = app.getContactHelper().all();
    UserData user = new UserData().withFirstname("Test23").withLastname("Test113").
            withAddress("Test4443").withPhone("5343");
    app.getContactHelper().createUser(user);
    app.goTo().gotoHomePage();
    Contacts after = app.getContactHelper().all();
    assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded
            (user.withId(after.stream().
                    mapToInt((u) -> u.getId()).max().getAsInt()))));
      }
    }



