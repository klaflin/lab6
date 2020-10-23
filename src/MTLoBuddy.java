
// represents an empty list of Person's buddies
class MTLoBuddy implements ILoBuddy {
  MTLoBuddy() {
  }

  // no persons in the MTList
  public boolean contains(Person that) {
    return false;
  }

  // returns the number of shared buddies between this and other
  public int countSame(ILoBuddy other) {
    return 0;
  }

  // no friends to have buddies
  public boolean extendedBuddy(Person that) {
    return false;
  }

  // counts the people in the list
  public int countAllFriends() {
    System.out.println("done counting!");
    return 0;
  }

  // once we reach the end of a network, we return the Person's we've been
  // collecting
  public ILoBuddy getGuestsHelp(ILoBuddy acc) {
    return acc;
  }

}
