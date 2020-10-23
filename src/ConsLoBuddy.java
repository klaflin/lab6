
// represents a list of Person's buddies
class ConsLoBuddy implements ILoBuddy {

  Person first;
  ILoBuddy rest;

  ConsLoBuddy(Person first, ILoBuddy rest) {
    this.first = first;
    this.rest = rest;
  }

  // is that person in this list of Person?
  public boolean contains(Person that) {
    return this.first.equals(that) || this.rest.contains(that);
  }

  // counts the number of buddies shared between the lists
  public int countSame(ILoBuddy other) {
    if (other.contains(this.first)) {
      return 1 + this.rest.countSame(other);
    }
    else {
      return this.rest.countSame(other);
    }
  }

  // is that person an extended buddy of this list?
  public boolean extendedBuddy(Person that) {
    return this.first.hasDirectBuddy(that) || this.rest.extendedBuddy(that);
  }

  // counts all of the people in the list
  public int countAllFriends() {
    System.out.println("counting " + this.first.username);
    return 1 + this.rest.countAllFriends();
  }

  // collects the list of people you can reach, excluding duplicates
  public ILoBuddy getGuestsHelp(ILoBuddy acc) {
    ILoBuddy newAcc = acc;
    if (newAcc.contains(this.first)) {
      System.out.println("\thit " + this.first.username + " again");
      return this.rest.getGuestsHelp(newAcc);
    }
    else {
      System.out.println("adding: " + this.first.username);
      newAcc = new ConsLoBuddy(this.first, acc);
      return this.rest.getGuestsHelp(this.first.buddies.getGuestsHelp(newAcc));
    }
  }

}
