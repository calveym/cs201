// Operations on binary search trees of integers
//
// for CS 201 Exam 2
//
// Name:

public class IntBSTops {

    // problem 1 --------------------------------------------------
    
    public static int height(IntBST t) {
        // returns height of t  (==1 if t is leaf!)

        // FILL IN for problem 1

        return 0; // just a placeholder
    }

    public static int balanceFact(IntBST t) {
        // returns balance factor of t, i.e. height(right) - height(left)

        // FILL IN for problem 1

        return 0; // just a placeholder
    }

    public static boolean isBalanced(IntBST t) {
        // returns whether t is balanced

        // FILL IN for problem 1

        return true; // just a placeholder
    }

    // problem 2 --------------------------------------------------
    // depends on answers from problem 1
    
    public static void balance(IntBST t) {
        // finds unbalanced nodes in tree and performs rotation

        // FILL IN for problem 2
    }

    
    // problem 3 --------------------------------------------------
    
    public static int width(IntBST t) {
        // returns width of t:
        // 0 if t is null
        // 2 if t is a leaf
        // if one child is null, 1 + width of the other child
        // otherwise, the sum of the widths of t's subtrees
        
        // FILL IN for problem 3

        return 0; // just a placeholder
    }

    public static int leftWidth(IntBST t) {
        // returns width of left "half" of t:
        // 0 if t is null
        // otherwise, the width of t's left subtree (but at least 1)
        
        // FILL IN for problem 3

        return 0; // just a placeholder
    }

    public static int rightWidth(IntBST t) {
        // returns width of right "half" of t:
        // 0 if t is null
        // otherwise, the width of t's right subtree (but at least 1)

        // FILL IN for problem 3

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
