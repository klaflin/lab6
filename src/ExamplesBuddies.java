import tester.*;

// runs tests for the buddies problem
public class ExamplesBuddies {
  
  Person ann, bob, cole, dan, ed, fay, gabi, hank, jan, kim, len;
  
  ILoBuddy mt , annBuddies, kimCycle;
 
  
  void initBuddies() {
    ann = new Person("ann");
    bob = new Person("bob");
    cole = new Person("cole");
    dan = new Person("dan");
    ed = new Person("ed");
    fay = new Person("fay");
    gabi = new Person("gabi");
    hank = new Person("hank");
    jan = new Person("jan");
    kim = new Person("kim");
    len = new Person("len");
    //ann's buddies are bob and cole
    this.ann.addBuddy(this.bob);
    this.ann.addBuddy(this.cole);
    //Bob's buddies are Ann and Ed and Hank
    this.bob.addBuddy(this.ann);
    this.bob.addBuddy(this.ed);
    this.bob.addBuddy(this.hank);
    //Cole's buddy is Dan
    this.cole.addBuddy(this.dan);
    //Dan's buddy is Cole
    this.dan.addBuddy(this.cole);
    //Ed's buddy is Fay
    this.ed.addBuddy(this.fay);
    //Fay's buddies are Ed and Gabi
    this.fay.addBuddy(this.ed);
    this.fay.addBuddy(this.gabi);
    //Gabi's buddies are Ed and Fay
    this.gabi.addBuddy(this.ed);
    this.gabi.addBuddy(this.fay);
    //Hank does not have any buddies
    //Jan's buddies are Kim and Len
    this.jan.addBuddy(this.kim);
    this.jan.addBuddy(this.len);
    //Kim's buddies are Jan and Len
    this.kim.addBuddy(this.jan);
    this.kim.addBuddy(this.len);
    //Len's buddies are Jan and Kim
    this.len.addBuddy(this.jan);
    this.len.addBuddy(this.kim);

    annBuddies = new ConsLoBuddy(this.cole, new ConsLoBuddy(this.bob, this.mt));
    kimCycle = new ConsLoBuddy(this.jan, new ConsLoBuddy(this.kim, new ConsLoBuddy(this.len, this.mt)));
  }
 
  void testAddBuddy(Tester t) {
    ann = new Person("ann");
    t.checkExpect(this.ann.buddies, this.mt);
    this.initBuddies();
    t.checkExpect(this.ann.buddies, this.annBuddies);
  }
  
  void testGetBuddies(Tester t) {
    this.initBuddies();
    t.checkExpect(this.hank.getFriends(), this.mt);
    t.checkExpect(this.cole.getFriends(), new ConsLoBuddy(this.cole, new ConsLoBuddy(this.dan, this.mt)));
    t.checkExpect(this.kim.getFriends(), this.kimCycle);
  }
  
  void testHasDirectBuddy(Tester t) {
    this.initBuddies();
    t.checkExpect(this.ann.hasDirectBuddy(this.cole), true);
    t.checkExpect(this.ann.hasDirectBuddy(this.ed), false);
    t.checkExpect(this.hank.hasDirectBuddy(this.ed), false);
  }
  
  void testCommonBuddies(Tester t) {
    this.initBuddies();
    t.checkExpect(this.ann.countCommonBuddies(this.cole), 0);
    t.checkExpect(this.hank.countCommonBuddies(this.ed), 0);
    t.checkExpect(this.bob.countCommonBuddies(this.fay), 1);
    t.checkExpect(this.len.countCommonBuddies(this.jan), 1);
  }
  
  void testExtendedBuddies(Tester t) {
    this.initBuddies();
    t.checkExpect(this.ann.hasExtendedBuddy(this.cole), true);
    t.checkExpect(this.ann.hasExtendedBuddy(this.fay), true);
    t.checkExpect(this.hank.hasExtendedBuddy(this.cole), false);
    t.checkExpect(this.jan.hasExtendedBuddy(this.cole), false);
  }
  
  void testPartyCount(Tester t) {
    this.initBuddies();
    t.checkExpect(this.ann.partyCount(), 8);
    t.checkExpect(this.hank.partyCount(), 1);
    t.checkExpect(this.kim.partyCount(), 3);
    t.checkExpect(this.gabi.partyCount(), 3);
  }

}