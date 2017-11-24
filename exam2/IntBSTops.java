// Operations on binary search trees of integers
//
// for CS 201 Exam 2
//
// Name: Michael Calvey

public class IntBSTops {

    // problem 1 --------------------------------------------------

    // main func
    public static void main(String[] args) {
        IntBST t = new IntBST(6);
        t.add(4);
        t.add(5);
        t.add(8);
        t.add(7);
        t.add(9);
        p(Integer.toString(leftWidth(t)));
    }

    // debugging method
    public static void p(String s) {
        System.out.println(s);
    }

    // returns height of t  (==1 if t is leaf!)
    public static int height(IntBST t) {
        if(t == null)
            return 0;
        if(t.isLeaf())
            return 1;
        if(t.left() != null && t.right() != null) {
            if(height(t.left()) >= height(t.right()))
                return 1 + height(t.left());
            else if(height(t.right()) > height(t.left()))
                return 1 + height(t.right());
            else return 0;
        }
        else if(t.left() != null && t.right() == null) {
            return 1 + height(t.left());
        }
        else if(t.right() != null && t.left() == null) {
            return 1 + height(t.right());
        }
        else return 0;
    }

    // returns balance factor of tree t
    public static int balanceFact(IntBST t) {
        return height(t.right()) - height(t.left());
    }

    // returns true if the tree is balanced (balanced == |balanceFact| <= 1)
    public static boolean isBalanced(IntBST t) {
        if(t == null)
            return true;
        if(t.isLeaf())
            return true;
        else if (balanceFact(t) > 1 || balanceFact(t) < -1)
            return false;
        else if(t.left() != null && t.right() != null)
            return (isBalanced(t.left()) &&  isBalanced(t.right()));
        else
            return true; // just a placeholder
    }

    // problem 2 --------------------------------------------------
    // depends on answers from problem 1

    public static void balance(IntBST t) {
        // balance subtrees recursively first if they exist
        if(t == null)
            return;
        balance(t.left());
        balance(t.right());

        // subtrees done, balance current node
        if(balanceFact(t) > 1) {
            // if(t.right() == null || t.left() == null)
            //     return;
            if(balanceFact(t.right()) <= -1)
                t.right().rotateRight();
            p("Gets here boi");
            t.rotateLeft();
        } else if (balanceFact(t) < -1) {
            if(balanceFact(t.left()) >= 1)
                t.left().rotateLeft();
            p("Gets here fam less than one");
            t.rotateRight();
        }
    }


    // problem 3 --------------------------------------------------

    public static int width(IntBST t) {
        // returns width of t:
        // 0 if t is null
        // 2 if t is a leaf
        // if one child is null, 1 + width of the other child
        // otherwise, the sum of the widths of t's subtrees

        if(t == null)
            return 0;
        if(t.isLeaf())
            return 2;
        if(t.right() != null && t.left() == null)
            return 1 + width(t.right());
        if(t.left() != null && t.right() == null)
            return 1 + width(t.left());
        else
            return width(t.right()) + width(t.left());
    }

    public static int leftWidth(IntBST t) {
        // returns width of left "half" of t:
        // 0 if t is null
        // otherwise, the width of t's left subtree (but at least 1)

        if(t == null)
            return 0;
        if(t.isLeaf())
            return 1;
        else
            return 1 + leftWidth(t.left());
    }

    public static int rightWidth(IntBST t) {
        // returns width of right "half" of t:
        // 0 if t is null
        // otherwise, the width of t's right subtree (but at least 1)

        if(t == null)
            return 0;
        if(t.isLeaf())
            return 1;
        else return 1 + rightWidth(t.right());

        return 0; // just a placeholder
    }

    // problem 4 --------------------------------------------------

    public static IntBST smallest(IntBST t) {
        // returns first node in t

        // FILL IN for problem 4

        return null; // just a placeholder
    }

    public static IntBST largest(IntBST t) {
        // returns last node in t

        // FILL IN for problem 4

        return null; // just a placeholder
    }

    // problem 5 --------------------------------------------------

    public static IntBST next(IntBST t) {
        // returns next node after current according to in-order traversal
        // or null if no more

        // FILL IN for problem 5

        return null; // just a placeholder
    }

    // -------------------------------------------------------------

    public static String traverseRec(IntBST t) {
        // creates string with values in t using recursive in-order traversal
        StringBuffer sb = new StringBuffer(" ");
        traverseRec1(sb, t);
        return sb.toString();
    }
    private static void traverseRec1(StringBuffer sb, IntBST t) {
        if (t != null) {
            traverseRec1(sb, t.left());
            sb.append(t.value() + " ");
            traverseRec1(sb, t.right());
        }
    }
    public static String traverseLoop(IntBST t) {
        // creates string with values in t using loop
        StringBuffer sb = new StringBuffer(" ");
        for (IntBST node = smallest(t); node != null; node = next(node))
            sb.append(node.value() + " ");
        return sb.toString();
    }
}
