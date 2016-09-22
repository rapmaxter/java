package white.box.tester.tests;

import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

/**
 * Created by Max on 9/19/2016.
 */
public class DeleteGroup extends TestBase {

  @Test
  public void testsGroups() {

    app.getNavigationHelper().gotoGroupPage();
    app.getNavigationHelper().nameGroupeselected();
    app.getGroupHelper().groupeDelete();
    app.getGroupHelper().returnGroupPage();
  }

}

