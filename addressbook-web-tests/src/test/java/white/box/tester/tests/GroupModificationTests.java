package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Max on 9/19/2016.
 */
public class GroupModificationTests extends TestBase   {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData("Test2", null, "Test5"));}
  }

  @Test
  public void testGroupModification () {


    List<GroupData> before = app.group().list();
   int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "Test1", null, "Test5");
    app.group().modify(index, group);
    app.goTo().GroupPage();
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
