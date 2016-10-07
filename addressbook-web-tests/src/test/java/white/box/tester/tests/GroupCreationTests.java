package white.box.tester.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testsGroups() {

    app.goTo().GroupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData("Test1", null, "Test5");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
    for (GroupData g : after){
      if (g.getId() > max ) {
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}