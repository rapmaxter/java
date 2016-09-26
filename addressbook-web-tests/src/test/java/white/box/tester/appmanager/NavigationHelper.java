package white.box.tester.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
    if (isElementPresent(By.tagName("h1"))
          && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
            return;
    }
      click(By.linkText("groups"));
    }


  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    wd.findElement(By.linkText("home")).click();
  }

  public void nameGroupeselected() {

    if (!wd.findElement(By.name("selected[]")).isSelected())
      wd.findElement(By.name("selected[]")).click();
  }

}
