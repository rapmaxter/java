package white.box.mantis.tests;

import org.testng.annotations.Test;
import white.box.mantis.model.Issue;
import white.box.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;
import static org.testng.Assert.assertEquals;

/**
 * Created by Max on 11/5/2016.
 */
public class SoapTests extends TestBase {

  @Test
  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }
@Test
  public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
  Set<Project> projects = app.soap().getProjects();
  Issue issue = new Issue().withSummary("Test issue")
          .withDescription("Test issue description")
          .withProject(projects.iterator().next());
  Issue created = app.soap().addissue(issue);
  assertEquals(issue.getSummary(), created.getSummary());
}
  }
