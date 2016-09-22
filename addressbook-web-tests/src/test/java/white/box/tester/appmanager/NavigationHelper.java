package white.box.tester.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Max on 9/18/2016.
 */
public class NavigationHelper extends HelperBase  {

  public NavigationHelper(WebDriver wd) {
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

}
