package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import java.util.List;

/**
 * Created by Max on 9/19/2016.
 */
public class GroupDeletingTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData("Test2", null, "Test5"));}
  }

  @Test
  public void testsGroups() {

    app.goTo().GroupPage();
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
    }


}



