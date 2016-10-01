package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import java.util.List;

/**
 * Created by Max on 9/19/2016.
 */
public class GroupDeletingTests extends TestBase {

  @Test
  public void testsGroups() {

    app.getNavigationHelper().gotoGroupPage();
    // Assert
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test3", null, "Test3"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().groupeDeleting();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
    }
  }



