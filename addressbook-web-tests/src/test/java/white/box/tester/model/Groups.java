package white.box.tester.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Max on 10/9/2016.
 */
public class Groups extends ForwardingSet<GroupData> {

 private Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

 public Groups() {
  this.delegate = new HashSet<GroupData>();
 }

  public Groups(Collection<GroupData> groups) {
    this.delegate = new HashSet<GroupData>(groups);

  }


  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  public Groups withAdded(GroupData group) {
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups withOut(GroupData group) {
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (this.size() != ((Groups) o).size()) {
      return false;
    }
    return this.containsAll((Groups) o);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (delegate != null ? delegate.hashCode() : 0);
    return result;
  }
}
