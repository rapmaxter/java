package white.box.tester.tests;

import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

/**
 * Created by Max on 9/19/2016.
 */
public class GroupModificationTests extends TestBase   {

  @Test
  public void testGroupModification () {

    app.getNavigationHelper().gotoHomePage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initModification();
    app.getGroupHelper().fillGroup(new GroupData("Test3", "Test3", "header3", "Test5"));
    app.getGroupHelper().submitGroupModification();
  }
}
