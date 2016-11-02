package white.box.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

/**
 * Created by Max on 9/18/2016.
 */
public class HelperBase {
  //private

  protected ApplicationManager app;

  protected WebDriver wd;

  public HelperBase(ApplicationManager app) {
    this.app = app;
    this.wd = app.getDriver();
  }

  protected WebElement findElement(By locator) {
    return wd.findElement(locator);
  }

  protected List<WebElement> findElements(By by) {
    return wd.findElements(by);
  }

  protected void click(By locator) {
    findElement(locator).click();
  }

  protected String getText(By locator) {
    return findElement(locator).getText();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text !=null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)){
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
     }
  }

  protected void attach(By locator, File file) {
    if (file !=null) {
      wd.findElement(locator).sendKeys(file.getAbsolutePath());
      }
    }


  protected boolean isElementPresent(By locator) {
    try{
      findElement(locator);
      return true;
    } catch (NoSuchElementException ex){
      return false;
    }
  }


  protected boolean isElementSelected(By id) {
    return findElement(id).isSelected();
  }
}

