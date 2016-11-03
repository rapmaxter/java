package white.box.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Max on 11/2/2016.
 */
public class ChangePassHelper extends HelperBase {

  public ChangePassHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }

  public void passreset() {
    wd.findElement(By.linkText("Manage")).click();
    wd.findElement(By.linkText("Manage Users")).click();
    wd.findElement(By.linkText("user55")).click();
    wd.findElement(By.xpath("//form[@id='manage-user-reset-form']/fieldset/span/input")).click();
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));

  }

}
