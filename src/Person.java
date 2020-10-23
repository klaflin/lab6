
// represents a Person with a user name and a list of buddies
class Person {

  String username;
  ILoBuddy buddies;

  Person(String username) {
    this.username = username;
    this.buddies = new MTLoBuddy();
  }
  
  // EFFECT:
  // Change this person's buddy list so that it includes the given person
 void addBuddy(Person buddy){
   this.buddies = new ConsLoBuddy(buddy, this.buddies);
 }
 
  //gets a list of all the Person's reachable through this Person's network
  ILoBuddy getFriends() {
    return this.getFriendsHelper(new MTLoBuddy());
  }
  
  // a helper function for getFriends
  ILoBuddy getFriendsHelper(ILoBuddy acc) {
    return this.buddies.getGuestsHelp(acc);
  }

  // returns true if this Person has that as a direct buddy
  boolean hasDirectBuddy(Person that) {
    return this.buddies.contains(that);
  }

  // returns the number of people who will show up at the party
  // given by this person
  int partyCount() {
    ILoBuddy friends = this.getFriends();
    if (friends.contains(this)) {
      return friends.countAllFriends();
    }
    else {
    return 1 + friends.countAllFriends();}
  }

  // returns the number of people that are direct buddies
  // of both this and that person
  int countCommonBuddies(Person that) {
    return this.buddies.countSame(that.buddies);
  }

  // will the given person be invited to a party
  // organized by this person?
  boolean hasExtendedBuddy(Person that) {
    ILoBuddy allBuds = this.getFriends();
    return allBuds.contains(that); 
  }

}
