package white.box.tester.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import white.box.tester.appmanager.ApplicationManage;

/**
 * Created by Max on 9/18/2016.
 */
public class TestBase {

  protected static final ApplicationManage app = new ApplicationManage(BrowserType.FIREFOX);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown()  {
    app.stop();
  }

}