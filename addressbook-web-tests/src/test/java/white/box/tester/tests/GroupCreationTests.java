package white.box.tester.tests;


import org.omg.CORBA.Object;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;
import white.box.tester.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

 @DataProvider
 public Iterator<Object[]> validGroups() {
   List<Object[]> list = new ArrayList<Object[]>();
   list.add(new Object[] {"test1", "header 1", "footer 1"});
   list.add(new Object[] {"test2", "header 2", "footer 2"});
   return list.iterator();
 }

  @Test (dataProvider = "validGroups")
  public void testsGroupCreation(String name, String header, String footer) {

    }

  @Test
  public void testsBadGroups() {

    app.goTo().GroupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Test1");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
