package white.box.tester.appmanager;

import com.sun.javafx.binding.ExpressionHelperBase;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import white.box.tester.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void groupeDelete() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();

  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroup(group);
    submitGroupCreation();
    returnGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public void groupeDeleting() {
    groupeDelete();
    returnGroupPage();
  }

  public void groupModofikation() {


    initGroupModification();
    fillGroup(new GroupData("Test2", "header3", "Test53"));
    submitGroupModification();
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
  List<GroupData> groups = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      GroupData group = new GroupData(name, null, null);
      groups.add(group);
    }
    return groups;
  }
}