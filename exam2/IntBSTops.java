// Operations on binary search trees of integers
//
// for CS 201 Exam 2
//
// Name: Michael Calvey
import java.util.Stack;

public class IntBSTops {

    // problem 1 --------------------------------------------------

    public static void levelOrderWrite(IntBST t) {
    // prints out the contents of the tree t in level order
        Stack<IntBST> q = new Stack<IntBST>();
        q.add(t);
        while (!q.empty()) {
            IntBST node = q.pop();
            if (node != null) {
                // breadth-first root, left, right
                System.out.print("  " + node.value());
                q.push(node.left());
                q.push(node.right());
            }
        }
        System.out.println();
    }

    // returns height of t  (==1 if t is leaf!)
    public static int height(IntBST t) {
        if(t == null) // base recursion case
            return 0;
        if(t.isLeaf())
            return 1;
        if(t.left() != null && t.right() != null) {
            // left and right nodes exist
            if(height(t.left()) >= height(t.right()))
                return 1 + height(t.left());
            else if(height(t.right()) > height(t.left()))
                return 1 + height(t.right());
            else return 0;
        } else if(t.left() != null && t.right() == null) {
            // only left nodes exist
            return 1 + height(t.left());
        } else if(t.right() != null && t.left() == null) {
            // only right nodes exist
            return 1 + height(t.right());
        } else return 0;
    }

    // returns balance factor of tree t
    public static int balanceFact(IntBST t) {
        System.out.println("Height: " + height(t.right()));
        System.out.println("Height l: " + height(t.left()));
        return height(t.right()) - height(t.left());
    }

    // returns true if the tree is balanced (balanced == |balanceFact| <= 1)
    public static boolean isBalanced(IntBST t) {
        if(t == null) // base recursion case
            return true;
        if(t.isLeaf()) // leaf always balanced
            return true;
        else if (balanceFact(t) > 1 || balanceFact(t) < -1) // break if imbalanced
            return false;
        else if(t.left() != null && t.right() != null) // check recursively
            return (isBalanced(t.left()) && isBalanced(t.right()));
        else return false;
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
            if(balanceFact(t.right()) <= -1)
                t.right().rotateRight();
            t.rotateLeft();
        } else if (balanceFact(t) < -1) {
            if(balanceFact(t.left()) >= 1)
                t.left().rotateLeft();
            t.rotateRight();
        }
    }


    // problem 3 --------------------------------------------------

    public static int width(IntBST t) {
        // returns width of t:
        if(t == null)        // 0 if t is null
            return 0;
        if(t.isLeaf())       // 2 if t is a leaf
            return 2;
        if(t.right() != null && t.left() == null)  // if one child is null, 1 + width of the other child
            return 1 + width(t.right());
        if(t.left() != null && t.right() == null)
            return 1 + width(t.left());
        else         // otherwise, the sum of the widths of t's subtrees
            return width(t.left()) + width(t.right());
    }

    public static int leftWidth(IntBST t) {
        // returns width of left "half" of t:
        // 0 if t is null
        // otherwise, the width of t's left subtree (but at least 1)
        if(t == null)
            return 0;
        if(t.isLeaf())
            return 1;
        else return width(t.left());
    }

    public static int rightWidth(IntBST t) {
        // returns width of right "half" of t:
        // 0 if t is null
        // otherwise, the width of t's right subtree (but at least 1)
        if(t == null)
            return 0;
        if(t.isLeaf())
            return 1;
        else return width(t.right());
    }

    // problem 4 --------------------------------------------------

    // returns smallest value
    public static IntBST smallest(IntBST t) {
        IntBST pos = t;
        while(pos.left() != null) // follow pointers until smallest reached
            pos = pos.left();
        return pos;
    }

    // returns largest value
    public static IntBST largest(IntBST t) {
        IntBST pos = t;
        while(pos.right() != null) // follow pointers until largest reached
            pos = pos.right();
        return pos;
    }

    // problem 5 --------------------------------------------------

    public static IntBST next(IntBST t) {
        if(t.right() != null) // try right first
            return smallest(t.right()); // if so return smallest of right node
        else { // else go up until next reached
            IntBST pos = t;
            while(pos.isRightChild())
                pos = pos.parent();
            return pos.parent();
        }
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
