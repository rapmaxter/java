package white.box.tester.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import white.box.tester.model.Contacts;
import white.box.tester.model.UserData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Max on 9/18/2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void createUser(UserData user) {
    newUser();
    fillUserField(user);
    submitCreating();
  }



  public void deleteUser() {
    //wd.findElement(By.cssSelector("input[value=Delete]")).click();
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
       {

    }
  }
  public void deleteFirstContact(UserData user) {
    initModificationById(user.getId());
    deleteUser();
    approveAllarm();
  }
  public void modify(UserData user) {
    initModificationById(user.getId());
    fillUserField(user);
    submitCreating();
  }

  // ==========================================================================================

  public void submitCreating() {

    wd.findElement(By.cssSelector("input[value=Enter]")).click();
   // click(By.xpath("//div[@id='content']/form/input[70]"));
  }

  public void fillUserField(UserData UserData) {
     type(By.name("firstname"), UserData.getFirstname());
    type(By.name("lastname"), UserData.getLastname());
    type(By.name("address"), UserData.getAddress());
    type(By.name("home"), UserData.getPhone());
  }

  public void newUser() {
    click(By.linkText("add new"));
  }

   public void initModification(int index) {
    // wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
    //wd.findElements(By.name("selected[]")).get(index).click();
    click(By.xpath("//*[@id='maintable']//tr[" + (index + 2) + "]/td[8]/a"));
  }

  public void initModificationById(int id) {
    //wd.findElements(By.name("selected[]")).get(index).click();
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }


  public void initUser() {
    By id = By.id("42");
    if (!isElementSelected(id))
      click(id);
  }

  public void deleteUser1() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }
  public void approveAllarm() {
    wd.switchTo().alert().accept();
  }


  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();

    List<WebElement> rows = findElements(By.cssSelector("tr[name=entry]"));

    for (WebElement row : rows) {
      int id = Integer.parseInt(row.findElement(By.cssSelector("td:first-of-type input")).getAttribute("id"));

      String firstname = row.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
      String lastname = row.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
      String address = row.findElement(By.cssSelector("td:nth-of-type(4)")).getText();
      String phone = row.findElement(By.cssSelector("td:nth-of-type(6)")).getText();

      contacts.add(new UserData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address).withPhone(phone));
    }
    return contacts;
  }


}