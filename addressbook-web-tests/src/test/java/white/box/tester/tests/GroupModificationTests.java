package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import javax.print.attribute.HashAttributeSet;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Max on 9/19/2016.
 */
public class GroupModificationTests extends TestBase   {

  @Test
  public void testGroupModification () {

    app.getNavigationHelper().gotoGroupPage();

    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test2", null, "Test5"));}

    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData(before.get(before.size() -1).getId(), "Test1", null, "Test5");
    app.getGroupHelper().selectGroup(before.size() - 1);  // Choice group: 0- first,...
    app.getGroupHelper().groupModofikation();
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
