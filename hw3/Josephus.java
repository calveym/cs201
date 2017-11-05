// Josephus.java
// Michael Calvey
// CS201 HW3 Assignment 2

public class Josephus
{
  // instance variables
  
  Circular circle;
  int skipNum;


  // constructor

  public Josephus(int numPeople, int numToSkip)
  // initialises circle with numPeople, saves skipNum
  {
    log("Solving Josephus problem with " + numPeople + " people, skipping " +
        numToSkip);
    circle = new CircularVector();
    for(int i = 0; i < numPeople; i++)
    {
      circle.addAfterCurrent(i + 1);
    }
    circle.next();
    skipNum = numToSkip;
  }


  // instance methods

  public void findMessenger()
  // controls skipping and removing until messenger is found
  {
    while(circle.size() != 1)
    {
      skip();
      remove();
    }
    log("The messenger is " + circle.getCurrent());
  }

  void skip()
  // skips through circular vector by skipNum times
  {
    for(int i = 0; i < skipNum; i++)
    {
      log("Skip " + circle.getCurrent());
      circle.next();
    }
  }

  void remove()
  // removes current item
  {
    log("Remove " + circle.getCurrent());
    circle.removeCurrent();
  }

  public void log(String s)
  // debug logging wrapper
  {
    System.out.println(s);
  }

  public static void main(String[] args)
  // Runs Josephus problem with a people skipping b people each time
  {
    if(args.length == 0)
    {
      System.out.println("usage: Josephus <numPeople> <numToSkip>");
      return;
    }
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    Josephus joe = new Josephus(a, b);
    joe.findMessenger();
  }
}
