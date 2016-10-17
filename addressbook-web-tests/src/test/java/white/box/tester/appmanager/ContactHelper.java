package white.box.tester.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import white.box.tester.model.ContactData;
import white.box.tester.model.Contacts;

import java.util.List;

/**
 * Created by Max on 9/18/2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void createUser(ContactData contact) {
    newUser();
    fillUserField(contact);
    submitCreating();
  }


  public void deleteFirstContact(ContactData contact) {
    selectContactById(contact.getId());
    deleteUser();
    approveAllarm();

    }
  public void modify(ContactData contact) {

    selectContactById(contact.getId());
    initModificationById(contact.getId());
    fillUserField(contact);
    submitModify();
  }

  private void submitModify() {
    wd.findElement(By.cssSelector("input[value=Update]")).click();
  }

  // ==========================================================================================

  public void submitCreating() {

    wd.findElement(By.cssSelector("input[value=Enter]")).click();
   // click(By.xpath("//div[@id='content']/form/input[70]"));
  }

  public void fillUserField(ContactData ContactData) {
     type(By.name("firstname"), ContactData.getFirstname());
    type(By.name("lastname"), ContactData.getLastname());
    type(By.name("address"), ContactData.getAddress());
    type(By.name("home"), ContactData.getHomephone());
    type(By.name("email"), ContactData.getEmail1());
    type(By.name("mobile"), ContactData.getMobile());

  }

  public void newUser() {
    click(By.linkText("add new"));
  }



  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteUser() {
    //wd.findElement(By.cssSelector("input[value=Delete]")).click();
    click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));

  }

  public void initModification(int index) {
    // wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
    //wd.findElements(By.name("selected[]")).get(index).click();
    click(By.xpath("//*[@id='maintable']//tr[" + (index + 2) + "]/td[8]/a"));
  }


  private void initModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

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

  private Contacts contactCache = null;

  public Contacts all() {
    Contacts contacts = new Contacts();

    List<WebElement> rows = findElements(By.cssSelector("tr[name=entry]"));

    for (WebElement row : rows) {
      int id = Integer.parseInt(row.findElement(By.cssSelector("td:first-of-type input")).getAttribute("id"));

      String firstname = row.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
      String lastname = row.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
      String address = row.findElement(By.cssSelector("td:nth-of-type(4)")).getText();
      String allemails = row.findElement(By.cssSelector("td:nth-of-type(5)")).getText();
      String allphones = row.findElement(By.cssSelector("td:nth-of-type(6)")).getText();

      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAddress(address).withAllphones(allphones).withAllemails(allemails));
    }
    return contacts;
  }


  public ContactData infoFormEditForm(ContactData contact) {
      initModificationById(contact.getId());
      String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
      String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
      String homephone = wd.findElement(By.name("homephone")).getAttribute("value");
      String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
      String workphone = wd.findElement(By.name("workphone")).getAttribute("value");
      String address = wd.findElement(By.name("address")).getAttribute("value");
      String email1 = wd.findElement(By.name("email1")).getAttribute("value");
      String email2 = wd.findElement(By.name("email2")).getAttribute("value");
      String email3 = wd.findElement(By.name("email3")).getAttribute("value");
      wd.navigate().back();
      return new ContactData()
              .withId(contact.getId())
              .withFirstname(firstname)
              .withLastname(lastname)
              .withHomephone(homephone)
              .withMobile(mobile)
              .withWorkphone(workphone)
              .withAddress(address)
              .withEmail1(email1)
              .withEmail2(email2)
              .withEmail3(email3);

    }


  public int count() {

    return wd.findElements(By.name("selected[]")).size();
  }
}



