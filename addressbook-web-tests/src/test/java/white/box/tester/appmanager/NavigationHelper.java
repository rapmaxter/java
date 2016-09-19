package white.box.tester.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Max on 9/18/2016.
 */
public class NavigationHelper extends HelperBase  {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
  public void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void nameGroupeselected() {

    if (!wd.findElement(By.name("selected[]")).isSelected())
      wd.findElement(By.name("selected[]")).click();
  }

  public void groupedelete() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();
  }
}
