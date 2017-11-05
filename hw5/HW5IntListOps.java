// CS 201 HW 5 Problem 1
// Name:Michael Calvey

public class HW5IntListOps extends IntListOps {

    // Tackle one at a time!!!   Test using
    // "java HW5IntListOpsTest"

    // Returns true or false if L is sorted
    public static boolean isSorted(IntList L) {
        if(isEmpty(L)) { return true; }
        if(isEmpty(tail(L))){ return true; }
        else if(length(L) <= 1){
            return true;
        } else {
            if(head(L) <= head(tail(L))) {
                return isSorted(tail(L));
            } else {
                return false;
            }
        }
    }

    // Removes all instances of i from L
    public static IntList remove(int i, IntList L) {
        if(isEmpty(L)) { return empty(); }
        else{
            if(head(L) == i) {
                return remove(i, tail(L));
            } else {
                return prepend(head(L), remove(i, tail(L)));
            }
        }
    }

    // Removes any duplicate items
    public static IntList removeDuplicates(IntList L) {
        if(isEmpty(L)) { return L; }
        else {
            return prepend(head(L), removeDuplicates(remove(head(L), tail(L))));
        }
    }
}
