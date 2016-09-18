package white.box.tester;


import org.testng.annotations.Test;


public class GroupsTests extends TestBase {

  @Test
  public void testsGroups() {

    gotoGroupPage();
    initGroupCreation();
    fillGroup(new GroupData("Test2", "Test2", "header1", "Test3"));
    submitGroupCreation();
    returnGroupPage();
  }

}
