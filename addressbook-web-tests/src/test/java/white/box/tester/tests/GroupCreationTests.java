package white.box.tester.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import java.util.Set;


public class GroupCreationTests extends TestBase {

  @Test
  public void testsGroups() {

    app.goTo().GroupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("Test1");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()); // преобразовали в поток индентификаторов
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
