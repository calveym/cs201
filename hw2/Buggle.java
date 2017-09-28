// Buggle.java
// Michael Calvey
// CS201 HW2 Assignment 5

public class Buggle {

    // Buggle variables

    boolean brushUp;
    int x, y;  // stores position in 2d space
    int direction;  // 0 = North, 1 = East, 2 = South, 3 = West


    // Constructors

    public Buggle() {
        x = 1;
        y = 1;
        brushUp = false;
        direction = 1;
    }


    // Instance methods - Interface

    // Changes direction to left
    public void left() {
        changeDirection(-1);
    }

    // Changes direction to right
    public void right() {
        changeDirection(1);
    }

    // Move buggle forward by amount
    public void forward(int amount) {
        if(direction == 0) {
            y += amount;
        } else if(direction == 1) {
            x += amount;
        } else if(direction == 2) {
            y -= amount;
        } else if(direction == 3) {
            x -= amount;
        }
    }

    // Move buggle forward by 1
    public void forward() {
        forward(1);
    }

    // String representation of class
    public String toString() {
        return "x=" + x + ", y=" + y + ", direction=" + getDir();
    }


    // Instance methods - Private

    // Returns direction transformed to a cardinal string
    private String getDir() {
        if(direction      == 0) { return "NORTH"; }
        else if(direction == 1) { return "EAST"; }
        else if(direction == 2) { return "SOUTH"; }
        else if(direction == 3) { return "WEST"; }
        else { return "INVALID"; }
    }

    // Changes direction to:
    // relative = -1 (left)
    // relative = 1 (right)
    // Self correcting - will detect if turned too much and wrap
    private void changeDirection(int relative) {
        direction += relative;
        if (direction == 4) {direction = 0;}
        if (direction == -1) {direction = 3;}
    }
}
