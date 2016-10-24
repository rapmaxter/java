package white.box.tester.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;
import white.box.tester.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Max on 9/19/2016.
 */
public class GroupModificationTests extends TestBase   {

  @BeforeMethod
  public void ensurePreconditions() {

    app.goTo().GroupPage();
    if (app.db().groups().size() == 0){
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

    @Test
  public void testGroupModification() {

    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
     GroupData group = new GroupData().
            withId(modifiedGroup.getId()).withName("Test1").withHeader("Test123").withFooter("Test5");
      app.goTo().GroupPage();
    app.group().modify(group);
    app.goTo().GroupPage();
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
  }
}
