package white.box.tester.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testsGroups() {

    app.getNavigationHelper().gotoGroupPage();

    List<GroupData> before = app.getGroupHelper().getGroupList();

   app.getGroupHelper().createGroup(new GroupData("Test3", null, "Test3"));

    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() + 1);
  }

}