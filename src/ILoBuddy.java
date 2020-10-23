
// represents a list of Person's buddies
interface ILoBuddy {
  // is this Person in the ILoBuddy?
  boolean contains(Person that);

  // counts the number of People shared between the two lists
  int countSame(ILoBuddy other);

  // is this person an extended buddy of the ILoBuddy?
  boolean extendedBuddy(Person that);

  // counts friends in the graph
  int countAllFriends();

  // creates a list of every reachable node from those in the starting list
  ILoBuddy getGuestsHelp(ILoBuddy acc);
}
