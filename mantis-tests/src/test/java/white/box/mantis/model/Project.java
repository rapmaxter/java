package white.box.mantis.model;

/**
 * Created by Max on 11/5/2016.
 */
public class Project {

  private int id;
  private String name;

  public String getStatus() {
    return status;
  }

  public Project withStatus(String status) {
    this.status = status;
    return this;
  }

  private String status;

  public int getId() {
    return id;
  }

  public Project withId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Project withName(String name) {
    this.name = name;
    return this;

  }
}
