// Skew heap of integers, implemented using IntTree
//
// based on Bailey's "SkewHeap"
//
// CS 201 HW 7
//
// Name: Michael Calvey

public class IntSkewHeap implements IntHeap {

    protected IntTree t;        // the heap

    // constructor
    public IntSkewHeap() {
        t = empty();
    }

    // private constructor (used by left() and right())
    protected IntSkewHeap(IntTree tree) {
        t = tree;
    }


    // returns true iff heap has no values
    public boolean isEmpty() {
        return isEmpty(t);
    }

    // returns the minimum int at the root of the heap ( = Bailey's getFirst())
    // pre: !isEmpty()
    public int value() {
        return t.value();
    }

    // removes all elements from the heap
    public void clear() {
        t = empty();
    }

    // returns left "sub-heap" of heap
    // pre: !isEmpty()
    public IntHeap left() {
        return new IntSkewHeap(t.left());
    }

    // returns right "sub-heap" of heap
    // pre: !isEmpty()
    public IntHeap right() {
        return new IntSkewHeap(t.right());
    }


    /************************************************************/

    /* You'll have to write the add and remove methods.
     *
     * Start by pasting in the appropriate code from
     * Bailey's "SkewHeap.java"
     */


    // adds value to heap
    public void add(int value) {
        this.merge(new IntSkewHeap(leaf(value)));
    }

    // removes and returns the minimum int at the root of the heap
    // pre: !isEmpty()
    public int remove() {
        int temp = value();
        this.t = merge(left(this.t), right(this.t));
        return temp;
    }

    // calls static merge function
    public void merge(IntSkewHeap otherHeap) {
        this.t = merge(this.t, otherHeap.t);
        otherHeap.t = null;
    }

    // recursively merges IntTrees l and r
    protected static IntTree merge(IntTree l, IntTree r) {
        if (isEmpty(l)) return r;
        if (isEmpty(r)) return l;
        int lVal = l.value();
        int rVal = r.value();
        IntTree result;
        if (rVal < lVal) {
            result = merge(r,l);
        } else {
            result = l;
            // assertion l side is smaller than r
            // l is new root
            if (isEmpty(result.left())) {
                result.setLeft(r);
            } else {
                IntTree temp = result.right();
                result.setRight(result.left());
                result.setLeft(merge(temp,r));
            }
        }
        return result;
    }


    /************************************************************/

    // Local abbreviations for static IntList methods

    public static IntTree empty() {
        return IntTree.empty();
    }

    public static boolean isEmpty(IntTree T) {
        return IntTree.isEmpty(T);
    }

    public static IntTree leaf(int val) {
        return IntTree.leaf(val);
    }

    public static int value(IntTree T) {
        return IntTree.value(T);
    }

    public static IntTree left(IntTree T) {
        return IntTree.left(T);
    }

    public static IntTree right(IntTree T) {
        return IntTree.right(T);
    }

    public static void setValue(IntTree T, int newValue) {
        IntTree.setValue(T, newValue);
    }

    public static void setLeft(IntTree T, IntTree newLeft) {
        IntTree.setLeft(T, newLeft);
    }

    public static void setRight(IntTree T, IntTree newRight) {
        IntTree.setRight(T, newRight);
    }
}
