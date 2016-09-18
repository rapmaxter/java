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
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillUserField(UserData UserData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(UserData.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(UserData.getLastname());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(UserData.getAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(UserData.getPhone());
  }

  public void newUser() {
    wd.findElement(By.linkText("add new")).click();
  }
}
