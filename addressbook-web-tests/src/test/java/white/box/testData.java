package white.box;

public class testData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String phone;

  public testData(String firstname, String lastname, String address, String phone) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.phone = phone;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }
}
