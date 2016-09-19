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
    type(By.name("firstname"), UserData.getLastname());
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

  public void initModification() {
    wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
  }

  public void deleteUser() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
    }

  public void initUser() {
    if (!wd.findElement(By.id("11")).isSelected())
      wd.findElement(By.id("11")).click();
  }

  public void deleteUser1() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void approveAllarm() {
    wd.switchTo().alert().accept();
  }
}
