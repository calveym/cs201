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
        // set up vars
        stack = new Stack<Integer>();

        setFont(new Font("TimesRoman", Font.BOLD, 28));

        // creates panels
        Panel res = new Panel();  // result container
        Panel buttons = new Panel();  // main container for numbers and operators
        Panel ec = new Panel();  // main container for enter and clear

        // setting layouts
        res.setLayout(new BorderLayout());
        buttons.setLayout(new GridLayout(4, 4));
        setLayout(new BorderLayout());
        ec.setLayout(new GridLayout(1, 2));

        // sets up main GUI arrangement
        add("North", res);
        add("Center", buttons);
        add("South", ec);

        // setting up result gui
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

        // adds result items
        res.add("Center", result);
        res.add("South", empty1);
        res.add("North", empty2);
        res.add("East", empty3);
        res.add("West", empty4);

        show(current);
    }

    // handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            String label = ((Button)e.getSource()).getLabel();
            if (label.equals("+")) {
                checkEnter();
                add();
            } else if (label.equals("-")) {
                checkEnter();
                sub();
            } else if (label.equals("*")) {
                checkEnter();
                mult();
            } else if (label.equals("/")) {
                checkEnter();
                div();
            } else if (label.equals("(-)"))
                swap();
            else if (label.equals("Enter"))
                enter();
            else if (label.equals("Clear"))
                clear();
            else if (label.equals("Pop"))
                pop();
            else     // number button
                number(Integer.parseInt(label));
        }
    }


    // helpers

    // create a colored button
    protected Button CButton(String s, Color fg, Color bg) {
        Button b = new Button(s);
        b.setBackground(bg);
        b.setForeground(fg);
        b.addActionListener(this);
        return b;
    }

    // display number n in result label
    protected void show(int n) {
        if(entered) {
            result.setForeground(red);
        }
        else {
            result.setForeground(dgreen);
        }
        result.setText(Integer.toString(n));
    }

    // enter if not entered
    protected void checkEnter() {
        if(!entered)
            enter();
    }

    // ensures pop is never called on empty stack
    protected int safePop() {
        if(stack.size() >= 1)
            return stack.pop();
        else
            return 0;
    }


    // button methods

    // handle add button
    protected void add() {
        int a = safePop();
        int b = safePop();
        current = a + b;
        enter();
    }

    // handle subtract button
    protected void sub() {
        int a = safePop();
        int b = safePop();
        current = b - a;
        enter();
    }

    // handle multiply button
    protected void mult() {
        int a = safePop();
        int b = safePop();
        current = a * b;
        enter();
    }

    // handle divide button
    protected void div() {
        int a = safePop();
        int b = safePop();
        current = b / a;
        enter();
    }

    // handle pop button
    protected void pop() {
        if(stack.size() >= 1)
            current = safePop();
        else
            current = 0;
        show(current);
    }

    // handle swap button
    protected void swap() {
        current *= -1;
        show(current);
    }

    // handle enter button
    protected void enter() {
        if(entered) {
            current = 0;
            return;
        }
        stack.push(current);
        entered = true;
        show(current);
        current = 0; // reset number
        entered = false; // reset entered
    }

    // handle clear button
    protected void clear() {
        current = 0;
        stack = new Stack<Integer>();
        show(current);
        entered = false;
    }

    // handle number buttons
    protected void number(int n) {
        if (current == 0) {
            current = n;
        }
        else if(String.valueOf(current).length() < 9) {
            current *= 10;
            current += n;
        }
        show(current);
    }

    // logger function
    protected void l(String s) {
        System.out.println(s);
    }
}
