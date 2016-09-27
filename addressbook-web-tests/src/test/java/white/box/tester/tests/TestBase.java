package white.box.tester.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import white.box.tester.appmanager.ApplicationManage;

/**
 * Created by Max on 9/18/2016.
 */
public class TestBase {

  protected final ApplicationManage app = new ApplicationManage(BrowserType.FIREFOX);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown()  {
    app.stop();
  }

}