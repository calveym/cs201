// SimpleFunctions.java
//
// CS 201 example

public class SimpleFunctions {

    public static int add(int num1, int num2){
	return num1 + num2;
    }

    public static void hello(int n){
	// print hello n times

	/* for loops consist of three parts:
	 * 1) a beginning statement that is only run once (initialization)
	 * 2) the condition or test to see if the loop should keep going (condition)
	 * 3) a statement that is run after each loop iteration (increment)
	 */
	for (int i = 1; i <= n; i++) {
	    System.out.println("Hello!");
	}
    }

    public static boolean isPrime(int num){
	for (int i = 2; i < num; i++) {// could stop at sqrt to make it faster...
	    if (num % i == 0) {  // % is the modulo operator, aka remainder
		return false;
	    }
	}

	return true;
    }

    public static void printPrimes(int numToPrint){
	int count = 0;
	int current = 2;

	while (count < numToPrint) {
	    if (isPrime(current)) {
		System.out.println(current);
		count++;
	    }
	    current++;
	}
    }

    public static void main(String[] args){
	int a = 5;
	int b = 3;
	int c = add(a, b);
	System.out.println(a + " plus " + b + " is " + c);

	hello(c);

	printPrimes(10);
    }
}
