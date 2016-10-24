package white.box.tester.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;
import white.box.tester.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


 @DataProvider
 public Iterator<Object[]> validGroups() throws IOException {
   try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
     String xml = "";
     String line = reader.readLine();
     while (line != null) {
       xml += line;
       line = reader.readLine();
     }
     XStream xStream = new XStream();
     xStream.processAnnotations(GroupData.class);
     List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
     return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList())
             .iterator();
   }
   }

  @Test (dataProvider = "validGroups")
  public void testsGroupCreation(GroupData group) {
            app.goTo().GroupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(before.withAdded(
      group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
      }

    @Test (enabled = false)
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
