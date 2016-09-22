package white.box.tester.appmanager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import white.box.tester.model.GroupData;

/**
 * Created by Max on 9/18/2016.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnGroupPage() {
    click(By.linkText("groups"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroup(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_header"), groupData.getHeader1());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void selectGroup() { click(By.name("selected[]"));
  }

  public void initModification() {click(By.name("edit"));
  }

  public void submitGroupModification() { click(By.name("update"));
  }

  public void groupeDelete() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();

  }

}