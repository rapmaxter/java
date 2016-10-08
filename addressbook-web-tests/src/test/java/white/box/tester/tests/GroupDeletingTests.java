package white.box.tester.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import java.util.List;
import java.util.Set;

/**
 * Created by Max on 9/19/2016.
 */
public class GroupDeletingTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("Test2"));}
  }

  @Test
  public void testsGroups() {

    app.goTo().GroupPage();
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
    }


}



