package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import javax.print.attribute.HashAttributeSet;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Max on 9/19/2016.
 */
public class GroupModificationTests extends TestBase   {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test2", null, "Test5"));}
  }

  @Test
  public void testGroupModification () {


    List<GroupData> before = app.getGroupHelper().getGroupList();
   int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "Test1", null, "Test5");
    app.getGroupHelper().modifyGroup(index, group);
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
