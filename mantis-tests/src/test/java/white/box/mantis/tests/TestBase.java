package white.box.mantis.tests;


import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import white.box.mantis.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
/**
 * Created by Max on 9/18/2016.
 */
public class TestBase {


  public static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown()  {
    app.stop();
  }

  public boolean isIssueOpen(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = app.soap().getMantisConnect();
    IssueData issue = mc.mc_issue_get("administrator", "root", BigInteger.valueOf(issueId));
    if (!issue.getStatus().getName().equals("closed")) {
      return true;
    } else {
      return false;
    }
  }

  public void skipIfNotFixed(int issueId) throws MalformedURLException, ServiceException, RemoteException, javax.xml.rpc.ServiceException  {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}