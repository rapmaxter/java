package white.box.tester.tests;


import org.testng.annotations.Test;
import white.box.tester.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testsGroups() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("Test3", null, "Test3"));
  }

}