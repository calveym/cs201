// CS 201 Homework 6
//
// Name: Michael Calvey

public class HW6IntTreeOps extends IntTreeOps {

    // public interface for starting weighting recursive call
    public static IntTree weightedTree(IntTree t) {
        return weightedTreeRecursive(t, 1);
    }

    // recursively called weightedTree function, multiplies values by level
    public static IntTree weightedTreeRecursive(IntTree t, int level) {
        if(isEmpty(t)) return empty();
        return node(t.value() * level, weightedTreeRecursive(t.left(), level+1),
                    weightedTreeRecursive(t.right(), level+1));
    }

    // returns true if trees have same geometry, but not necessarily values
    public static boolean compareTrees(IntTree a, IntTree b) {
        if(isEmpty(a) || isEmpty(b)) { return false; }
        if(isLeaf(a) && isLeaf(b)) { return true; }
        else if(isLeaf(a) != isLeaf(b)) { return false; }
        else if(!isLeaf(a) && !isLeaf(b)) {
            return compareTrees(left(a), left(b)) && compareTrees(right(a),
            right(b));
        }
        else return false;
    }

    // returns whether tree is considered full (All nodes have either 2
    // leaves or none)
    public static boolean testFullTree(IntTree t) {
        if (isEmpty(t)) {
            return false;
        } if (isEmpty(left(t)) && isEmpty(right(t))) {
            return true;
        } if (isLeaf(left(t)) != isLeaf(right(t))) {
            return false;
        } else if (isLeaf(left(t)) == isLeaf(right(t))) {
            return true;
        }
        else {
            return testFullTree(left(t)) && testFullTree(right(t));
        }
    }

    // returns true if tree is ordered
    public static boolean testOrderedTree(IntTree t) {
        if(isEmpty(t)) {
            return true;
        } else if(maxInt(left(t)) > value(t)) {
            return true;
        } else if(minInt(right(t)) < value(t)) {
            return false;
        } else {
            return (testOrderedTree(left(t)) && testOrderedTree(right(t)));
        }
    }

    // TODO: print nodes by level
    public static void levelOrderWrite(IntTree t) {
    }

    // tests all HW6 answers
    public static void main(String[] args) {
        // prepare testing trees
        IntTree[] trees = recreateTrees();

        if(args.length == 0 || args.length > 2) {
            System.out.println("usage: java HW6IntTreeOps <t1>\n" +
	                           "   or java HW6IntTreeOps <t1> <t2>\n\n" +
	                           "  Tests certain operations on selected tree(s).\n" +
	                           "  If one tree is specified, runs 'weightedTree()',\n" +
	                           "    'testFullTree()', and 'testOrderedTree()'.\n" +
	                           "  If two trees are specified, runs 'compareTrees()'.\n" +
	                           "  Valid tree numbers are 1 through 7.\n");
        } else if(args.length == 1) {
            int selection = Integer.parseInt(args[0]) -1;
            try {
                IntTree tree = trees[selection];
                System.out.println("Tree " + args[0] + ":");
                printTree(tree);
                System.out.println("weightedTree:");
                tree = weightedTree(tree);
                printTree(tree);
                System.out.println("testFullTree:    " + testFullTree(tree));
                System.out.println("testOrderedTree: " + testOrderedTree(trees[selection]));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please input numbers between 1 and 7 for tree selection");
            }
        } else {
            try {
                int sel1 = Integer.parseInt(args[0]) -1;
                int sel2 = Integer.parseInt(args[1]) -1;
                System.out.println("Tree " + sel1 + ":");
                printTree(trees[sel1]);
                System.out.println("Tree " + sel2 + ":");
                printTree(trees[sel2]);
                System.out.println("compareTrees:   " + compareTrees(trees[sel1], trees[sel2]));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please input numbers between 1 and 7 for tree selection");
            }
        }
    }

    // recreates all trees
    public static IntTree[] recreateTrees() {
        IntTree test1 = empty();
        IntTree test2 = node(3, empty(), empty());
        IntTree test3 = node(1, node(2, empty(), empty()), node(3, empty(),
                        empty()));
        IntTree test4 = node(2, node(1, empty(), empty()), node(3, empty(),
                        empty()));
        IntTree test5 = node(3, node(1, empty(), node(2, empty(), empty())),
                        node(4, empty(), node(5, empty(), empty())));
        IntTree test6 = node(3, node(1, empty(), empty()), node(4, node(2,
                        empty(), empty()), node(5, empty(), empty())));
        IntTree test7 = node(1, node(2, node(4, empty(), empty()), node(5,
                        empty(), empty())), node(3, node(6, empty(), empty()),
                        node(7, empty(), empty())));

        IntTree[] trees = {test1, test2, test3, test4, test5, test6, test7};
        return trees;
    }

    // uses a loop to preOrder print the trees in the array
    public static void printTrees(IntTree[] trees) {
        for( int i = 0; i < trees.length; i++ ) {
            System.out.print(i + ": ");
            preOrderWrite(trees[i]);
            System.out.println(" ");
        }
    }

    // helper function for getting smallest int from tree
    public static int minInt(IntTree t) {
        if(isEmpty(t)) {
            return Integer.MAX_VALUE; // very large positive number
        } else {
            return Math.min(value(t), Math.min(minInt(left(t)),
                                               minInt(right(t))));
        }
    }
}
