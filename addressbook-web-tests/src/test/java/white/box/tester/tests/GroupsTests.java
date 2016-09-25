package white.box.tester.tests;


import org.testng.annotations.Test;
import white.box.tester.model.GroupData;


public class GroupsTests extends TestBase {

  @Test
  public void testsGroups() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroup(new GroupData("Test2", "Test2", "header1", "Test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupPage();
  }

}