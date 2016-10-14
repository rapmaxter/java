package white.box.tester.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import white.box.tester.model.UserData;

import java.util.ArrayList;
import java.util.List;

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

  public void deleteFirstContact() {
    initModification(0);
    deleteUser();
  }


  // ==========================================================================================

  public void submitCreating() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
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
    //wd.findElements(By.name("selected[]")).get(index).click();
    click(By.xpath("//*[@id='maintable']//tr[" + (index + 2) + "]/td[8]/a"));
  }

  public void deleteUser() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void initUser() {
    By id = By.id("42");
    if (!isElementSelected(id))
      click(id);
  }

  public void deleteUser1() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<UserData> getContactList() {
    List<UserData> contacts = new ArrayList<UserData>();

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