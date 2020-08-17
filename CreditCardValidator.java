import java.util.Scanner;

public class CreditCardValidator {
    public static void main(final String[] args) {
        System.out.println("enter a credit card number");
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        System.out.println(number + " is " + (isValid(number) ? "valid" : "invalid"));
    }
    public static Boolean isValid(long number)
    {
        return (getSize(number)) >= 13 && 
            getSize(number) <= 16 && 
            (prefixMatch(number, 4) ||
            prefixMatch(number, 5) ||
            prefixMatch(number, 37) ||
            prefixMatch(number, 6)) &&
            ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) %10 == 0);
    }
    public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        int n = getSize(number);
        for (int i = 1; i < n; i += 2){
            sum += getDigit(2 * getDigitFromIndex (number, i));
        }
        return sum;  
    }
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        int n = getSize(number);
        for (int i = 0; i < n; i += 2){
            sum += getDigit(getDigitFromIndex (number, i));
        }
        return sum; 
    }
    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number)
    {
        int n = getSize(number);
        if (n == 1){
            return number;
        }
        else {
            return getDigitFromIndex (number, 0) + getDigitFromIndex (number, 1);
        }
    }
    public static int getDigitFromIndex(long number, int i)
    {
        String digit = number + "";
        char value = digit.charAt(getSize(number) -  1 - i); 
        return value - '0';
    }
    
    public static boolean prefixMatch(long number, int d)   
    {
        boolean isValid = false;
        if (d == 4 || d == 5 || d == 6){
            isValid = (getPrefix(number, 1) == d);
        }
        else if (d == 37){
            isValid = (getPrefix(number, 2) == d);
        }
        return isValid;
    } 
     public static int getSize(long d)  
    {
        String num = d + "";
        return num.length();
    }
    public static long getPrefix(long number, int k)
    {
       if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0,k));
       }
       return number;
    }
}