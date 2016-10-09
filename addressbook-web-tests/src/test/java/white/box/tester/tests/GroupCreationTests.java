package white.box.tester.tests;



import org.testng.annotations.Test;
import white.box.tester.model.GroupData;
import white.box.tester.model.Groups;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupCreationTests extends TestBase {

  @Test
  public void testsGroups() {

    app.goTo().GroupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Test1");
    app.group().create(group);
    Groups after = app.group().all();
    assertEquals(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
