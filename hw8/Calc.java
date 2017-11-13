// Postfix Calculator Applet
//
// CS 201 HW 8  -  Skeleton
// Michael Calvey

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; // for Stack

public class Calc extends Applet implements ActionListener {

    private static final long serialVersionUID = 1L; // to avoid Eclipse warning

    // instance variables

    protected Label result;         // label used to show result
    protected Stack<Integer> stack; // stack used for calculations
    protected int current;          // current number being entered
    protected boolean entered;      // whether current number has been entered
                                    // if so, show number in red

    // local color constants
    static final Color black = Color.black;
    static final Color white = Color.white;
    static final Color red = Color.red;
    static final Color blue = Color.blue;
    static final Color yellow = Color.yellow;
    static final Color orange = Color.orange;
    static final Color lblue = new Color(200, 220, 255);
    static final Color dred = new Color(160, 0, 100);
    static final Color dgreen = new Color(0, 120, 90);
    static final Color dblue = Color.blue.darker();

    public void init() {
        setFont(new Font("TimesRoman", Font.BOLD, 28));

        // add your code here to set up the applet.

        // hint: to get the blue border around the result label,
        // I used a BorderLayout and added empty labels to the borders

        // make good use of helper methods to keep your code readable -
        // a rule of thumb is: if it doesn't fit on the screen, the
        // method is too long (and you might loose points :( )


        // just a placeholder to get it to compile and to demonstrate
        // the event handling:
        // Create panels to organise GUI
        Panel res = new Panel();  // result container
        Panel buttons = new Panel();  // main container for numbers and operators
        Panel ec = new Panel();  // main container for enter and clear


        res.setLayout(new BorderLayout());
        buttons.setLayout(new GridLayout(4, 4));
        setLayout(new BorderLayout());
        ec.setLayout(new GridLayout(1, 2));

        // sets up main GUI arrangement
        add("North", res);
        add("Center", buttons);
        add("South", ec);

        result = new Label("result", Label.RIGHT);
        Label empty1 = new Label("  ", Label.LEFT);
        Label empty2 = new Label("  ", Label.LEFT);
        Label empty3 = new Label("  ", Label.LEFT);
        Label empty4 = new Label("  ", Label.LEFT);
        empty1.setBackground(dblue);
        empty2.setBackground(dblue);
        empty3.setBackground(dblue);
        empty4.setBackground(dblue);

        // Adds main action buttons
        buttons.add(CButton("7", red, dblue));
        buttons.add(CButton("8", red, dblue));
        buttons.add(CButton("9", red, dblue));
        buttons.add(CButton("+", orange, dblue));
        buttons.add(CButton("4", red, dblue));
        buttons.add(CButton("5", red, dblue));
        buttons.add(CButton("6", red, dblue));
        buttons.add(CButton("-", orange, dblue));
        buttons.add(CButton("1", red, dblue));
        buttons.add(CButton("2", red, dblue));
        buttons.add(CButton("3", red, dblue));
        buttons.add(CButton("*", orange, dblue));
        buttons.add(CButton("0", red, dblue));
        buttons.add(CButton("(-)", red, dblue));
        buttons.add(CButton("Pop", red, dblue));
        buttons.add(CButton("/", orange, dblue));

        // Adds secondary action buttons
        ec.add(CButton("Enter", dblue, lblue));
        ec.add(CButton("Clear", dblue, lblue));

        res.add("Center", result);
        res.add("South", empty1);
        res.add("North", empty2);
        res.add("East", empty3);
        res.add("West", empty4);


        //
        // result = new Label("result");
        // add(result);
        // add(CButton("+", dblue, orange));
        // add(CButton("3", dgreen, yellow));
        // add(CButton("9", dgreen, yellow));

    }


    // a useful helper methods, given to you for free!

    // create a colored button
    protected Button CButton(String s, Color fg, Color bg) {
        Button b = new Button(s);
        b.setBackground(bg);
        b.setForeground(fg);
        b.addActionListener(this);
        return b;
    }

    // handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            String label = ((Button)e.getSource()).getLabel();
            if (label.equals("+"))
                add();
            else if (label.equals("-"))
                sub();
            else if (label.equals("*"))
                mult();


            // add similar calls for all other "non-number" buttons


            else {     // number button
                int n = Integer.parseInt(label);
                number(n);
            }
        }
    }

    // display number n in result label
    protected void show(int n) {
        result.setText(Integer.toString(n));
    }


    // just placeholders to get it to compile

    // handle add button
    protected void add() {
        System.out.println("add was pressed");
    }
    protected void sub() {
    }
    protected void mult() {
    }

    // handle number buttons
    protected void number(int n) {
        show(n);
    }
}
