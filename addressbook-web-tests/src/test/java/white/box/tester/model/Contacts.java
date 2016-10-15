package white.box.tester.model;

import com.google.common.collect.ForwardingSet;
import com.sun.jna.platform.win32.Netapi32Util;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Max on 10/14/2016.
 */
public class Contacts extends ForwardingSet<ContactData> {

  private  Set<ContactData> delegate;


    public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<ContactData>();
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate;
  }

  public Contacts withAdded(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }
  public Contacts withOut(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }
}
