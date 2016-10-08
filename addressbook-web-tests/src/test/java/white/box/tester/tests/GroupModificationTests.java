package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
   int index = before.size() - 1;
    GroupData group = new GroupData().
            withId(modifiedGroup.getId()).withName("Test1").withHeader("Test123").withFooter("Test5");
    app.group().modify(group);
    app.goTo().GroupPage();
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before,after);
  }
}
