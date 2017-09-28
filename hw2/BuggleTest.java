// BuggleTest.jav
// Michael Calvey
// CS201 HW2 Assignment 5

public class BuggleTest {

    // Runs test functions
    public static void main(String[] args) {
        // create a Buggle
        Buggle becky = new Buggle();
        // print it (this invokes the toString() method)
        log("becky: " + becky);

        // move becky around a bit and keep printing it
        becky.forward();  log("becky: " + becky);
        becky.left();     log("becky: " + becky);
        becky.forward(5); log("becky: " + becky);

        // create another Buggle and print it
        Buggle bobby = new Buggle();
        log("bobby: " + bobby);

        // move bobby without printing
        bobby.right();
        bobby.forward(5);
        bobby.right();
        bobby.forward(20);
        bobby.left();

        // move becky some more
        becky.left();
        becky.forward(3);

        // report final state of both Buggles
        log("becky: " + becky);
        log("bobby: " + bobby);
    }

    // System.out.println wrapper
    public static void log(String s) {
        System.out.println(s);
    }
}
