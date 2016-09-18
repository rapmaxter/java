package white.box.tester.tests;


import org.testng.annotations.Test;
import white.box.tester.model.GroupData;


public class GroupsTests extends TestBase {

  @Test
  public void testsGroups() {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroup(new GroupData("Test2", "Test2", "header1", "Test3"));
    app.submitGroupCreation();
    app.returnGroupPage();
  }

}