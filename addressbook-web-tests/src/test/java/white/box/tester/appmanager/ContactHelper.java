package white.box.tester.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import white.box.tester.model.UserData;

/**
 * Created by Max on 9/18/2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(FirefoxDriver wd) {


    super(wd);
  }

  public void submitCreating() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillUserField(UserData UserData) {
    type(By.name("lastname"), UserData.getLastname());
    type(By.name("address"), UserData.getAddress());
    type(By.name("home"), UserData.getPhone());
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void newUser() {
    click(By.linkText("add new"));
  }
}
