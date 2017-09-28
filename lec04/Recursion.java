public class Recursion {

  public static int fact(int n ) {
    if (n <= 0) {
      return 1;
    } else {
    return n * fact(n - 1);}
  }

  public static void main(int[] args) {
    System.out.println(fact(15));
  }
}
