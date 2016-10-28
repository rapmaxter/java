package white.box.tester.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

  public void addContact(ContactData contact) {
    selectContactById(contact.getId());
    selectGroup(contact);
    approveContactInGroupe();
  }

  private void approveContactInGroupe() {
    click(By.name("add"));
  }

  private void selectGroup(ContactData contact) {
    new Select(wd.findElement(By.name("to_group")))
                        .selectByVisibleText(contact.getGroups().iterator().next().getName());
  }

  // ==========================================================================================

  private void submitModify() {
    wd.findElement(By.cssSelector("input[value=Update]")).click();
  }

  public void submitCreating() {

    wd.findElement(By.cssSelector("input[value=Enter]")).click();
   // click(By.xpath("//div[@id='content']/form/input[70]"));
  }

  public void fillUserField(ContactData ContactData) {
    type(By.name("firstname"), ContactData.getFirstname());
    type(By.name("lastname"), ContactData.getLastname());
    type(By.name("address"), ContactData.getAddress());
  //  type(By.name("home"), ContactData.getHomephone());
    type(By.name("email"), ContactData.getEmail1());
    type(By.name("mobile"), ContactData.getMobile());
    //attach(By.name("photo"), ContactData.getPhoto());
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

  private void openContactDetailsById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();

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




  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allemails = cells.get(4).getText();
      String allphones = cells.get(5).getText();
      ContactData contact = new ContactData()
              .withId(id).withFirstname(firstname).withLastname(lastname)
              .withAddress(address).withAllphones(allphones).withAllemails(allemails);

      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFormEditForm(ContactData contact) {
      initModificationById(contact.getId());
      String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
      String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
      String homephone = wd.findElement(By.name("home")).getAttribute("value");
      String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
      String workphone = wd.findElement(By.name("work")).getAttribute("value");
      String address = wd.findElement(By.name("address")).getAttribute("value");
      String email1 = wd.findElement(By.name("email")).getAttribute("value");
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


  public ContactData infoFromDetailsPage(ContactData contact) {
    openContactDetailsById(contact.getId());
    String contactDetails = wd.findElement(By.id("content")).getText();
    wd.navigate().back();
    return new ContactData().withDetails(contactDetails);
  }


}


