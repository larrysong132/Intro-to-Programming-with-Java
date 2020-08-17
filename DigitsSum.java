import java.util.*;

public class DigitsSum {
    public static void main(String[] args) {
      Scanner sc= new Scanner(System.in);
      System.out.println("input an interger between 0 and 1000");
      int a = sc.nextInt();
      System.out.println("The input value is " + a);
      int original= a;
      int digitsSum = 0;
      digitsSum = digitsSum + a % 10;
      a = a / 10;
      digitsSum = digitsSum + a % 10;
      a = a / 10;
      digitsSum = digitsSum + a % 10;
      System.out.println("The digits sum for " + original + " is " + digitsSum);
    }

}
