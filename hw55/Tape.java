// Tape.java
// Michael Calvey
// CS201 HW 5.5
import java.util.Stack;

public class Tape {

    Stack <Character> left; // Linear structure of all visited chars to left
    Stack <Character> right; // Linear structure of all visited chars to right
    Character current;

    public Tape() {
        left = new Stack<Character>();
        right = new Stack<Character>();
    }

    public static void main(String[] args) {
        Tape n = new Tape();
        n.store("s".charAt(0));
        n.right();
        n.store("u".charAt(0));
        n.right();
        n.store("p".charAt(0));
        n.right();
        n.store("e".charAt(0));
        n.right();
        n.store("r".charAt(0));
        n.left();
        n.left();
        n.display();
    }

    public void store(char c) {
        current = c;
    }

    public void left() {
        right.push(current);
        if(!left.isEmpty()) {
            current = left.pop();
        } else {
            current = "*".charAt(0);
        }
    }

    public void right() {
        left.push(current);
        if(!right.isEmpty()) {
            current = right.pop();
        }
        else {
            current = "*".charAt(0);
        }
    }

    public void display() {
        Stack<Character> reversedLeft = reverseStack(left);
        Stack<Character> saveLeft = left;
        Stack<Character> saveRight = right;
        int leftCount = left.size();
        int rightCount = right.size();
        System.out.println("Size: " + reversedLeft.size());

        // Iteratively prints left stack
        for(int i = 0; i < 2; i++) {
            System.out.println(reversedLeft.pop());
        }

        // prints current value
        System.out.println("Current: " + current);

        // Iteratively prints right stack
        for(int i = 0; i < rightCount; i++) {
            System.out.println(right.pop());
        }

        // Replaces old stack values before popping
        left = saveLeft;
        right = saveRight;
    }

    public Stack<Character> reverseStack(Stack<Character> rev) {
        Stack<Character> t = new Stack<Character>();
        for(int i = rev.size(); i > 0; i--) {
            t.push(rev.pop());
        }
        return t;
    }

}
