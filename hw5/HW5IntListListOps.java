// CS 201 HW 5 Problem 2
// Name:

public class HW5IntListListOps extends IntListListOps {

    // Tackle one at a time!!!   Test using
    // "java HW5IntListOpsTest"

    public static IntListList filterSorted (IntListList L) {
        // Returns a list of all of the lists of L that are sorted.
        // To use a method from HW5IntListOps.java, use the prefix
        // "HW5IntListOps."
        if(isEmpty(L)) { return empty(); } else {
            if(HW5IntListOps.isSorted(head(L))) {
                return prepend(head(L), filterSorted(tail(L)));
            } else return filterSorted(tail(L));
        }
    }

    public static IntListList mapPrepend (int i, IntListList L) {
        // Returns a new list that contains list elements in which i is
        // prepended to every corresponding element of the input list.
        // Note that this method uses both IntList and IntListList
        // methods. In the body, IntList methods must contain an explicit
        // "IntList." prefix, but no prefix is necessary for IntListList
        // methods.
        if(isEmpty(L)) { return empty(); } else {
            return prepend(IntListOps.prepend(i, head(L)), mapPrepend(i, tail(L)));
        }
    }

    public static IntListList subsequences (IntList L) {
        // Given an integer list L, return a list of all the subsequences
        // of L.  Think carefully about the base case!  Note that this
        // method uses both IntList and IntListList methods. In the body,
        // IntList methods must contain an explicit "IntList." prefix, but
        // no prefix is necessary for IntListList methods.
        if(IntListOps.length(L) < 2) { return prepend(L, empty()); } else {
            IntListList subs = subsequences(IntList.tail(L));
            IntListList added = mapPrepend(IntList.head(L), subs);
            added = prepend(IntList.prepend(IntList.head(L), IntList.empty()), added);
            return append(added, subs);
        }
    }


    // optional (extra credit):
    // please don't remove this method even if you don't tackle it so our test code runs

    public static IntListList longest (IntListList L) {

        // Returns a list of all of the lists of L that have the longest length.
        // If L is empty, returns the empty list.
        // Think carefully about base cases here!

        return empty();  // just a placeholder
    }
}
