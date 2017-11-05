// CircularVector.java
// Michael Calvey
// CS201 HW3 Assignment 1
import structure.*;


public class CircularVector implements Circular
{
    // variables

    public Vector list;  // holds people
    int current;  // currently pointed at person


    // constructors

    public CircularVector()
    {
        list = new Vector();
        current = -1;
    }


    // methods

    public void next()
    // selects next item in circular array, automatically wraps if end reached
    {
        if(list.size() == current + 1)
        // on last item, needs to wrap
        {
            current = 0;
        } else {
            current++;
        }
    }

    public int size()
    // returns size of list
    {
        return list.size();
    }

    public Object getCurrent()
    // returns currently pointed at object
    {
        return list.get(current);
    }

    public void removeCurrent()
    // removes current object
    {
        list.removeElementAt(current);
        if(current == size())
        {
            current = 0;
        }
    }

    public void addAfterCurrent(Object obj)
    // inserts obj after current element, makes obj current
    {
        if(size() == 0)
        {
            current = 0;
            list.add(0, obj);
        } else {
            list.add(current + 1, obj);
            current++;
        }
    }

    public void clear()
    // clears whole vector
    {
        list.removeAllElements();
        current = -1;
    }

    public static void log(String s)
    // logs "s" to console
    {
        System.out.println(s);
    }

    public static void main(String[] args)
    // main method runs function tests
    {
        log("creating new circular vector");
        Circular myList = new CircularVector();
        //log("size is " + myList.size());
        log("adding 7");
        myList.addAfterCurrent(7);
        log("adding 8");
        myList.addAfterCurrent(8);

        log("\ncalling next");
        myList.next();
        log("current should be 7: " + myList.getCurrent());
        myList.next();
        log("calling next");
        log("current should be 8: " + myList.getCurrent());
        log("\nAdding 15");
        myList.addAfterCurrent(15);
        log("Current should be 15: " + myList.getCurrent());

        myList.next();
        log("Current should be 7: " + myList.getCurrent());

        log("\nRemoving current element");
        myList.removeCurrent();
        log("Current should be: 8: " + myList.getCurrent());

        log("Clearing array");
        myList.clear();
        log("Current should be null: " + myList.getCurrent());
    }
}
