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
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("Test2"));}
  }

  @Test
  public void testGroupModification () {


    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
   int index = before.size() - 1;
    GroupData group = new GroupData().
            withId(modifiedGroup.getId()).withName("Test1").withHeader("Test123").withFooter("Test5");
    app.group().modify(group);
    app.goTo().GroupPage();
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());

    before.remove(modifiedGroup);
    before.add(group);
    assertEquals(before,after);
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
  }
}
