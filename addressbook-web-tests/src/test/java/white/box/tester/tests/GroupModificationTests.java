package white.box.tester.tests;

import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

/**
 * Created by Max on 9/19/2016.
 */
public class GroupModificationTests extends TestBase   {

  @Test
  public void testGroupModification () {

    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test3", null, "Test3"));}
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroup(new GroupData("Test2", "header3", "Test5"));
    app.getGroupHelper().submitGroupModification();
  }
}
