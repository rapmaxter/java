package white.box.tester.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by Max on 9/18/2016.
 */
public class HelperBase {
  //private
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
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
    if (text !=null) {
      WebElement element = findElement(locator);
      if (! text.equals(element.getText())){
        element.clear();
        element.sendKeys(text);
      }
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

  protected void approveAllarm() {
    wd.switchTo().alert().accept();
  }

  protected boolean isElementSelected(By id) {
    return findElement(id).isSelected();
  }
}

