import java.util.Scanner;

public class MultiplyTwoArbitraryIntegers {
    public static void main(final String[] args) {
        System.out.println("enter two integers");
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();
        // convert String to an Array;
        int[] firstNumber = convert(a);
        int[] secondNumber = convert(b); 
        System.out.println(multiply(firstNumber, secondNumber));
    }

    // converts from String to int array.
    public static int[] convert(String input) {
        int[] output;
        boolean hasNegative = false;
        if (input.charAt(0) == '-') {
            hasNegative = true;
        }
        if (hasNegative) {
            output = new int[input.length() - 1];
        } else {
            output = new int[input.length()];
        }
        int endIndex = input.length();
        if (hasNegative)
            endIndex--;
        for (int i = 0; i < endIndex; i++) {
            char digit;
            if (hasNegative) {
                digit = input.charAt(i + 1);
            } else {
                digit = input.charAt(i);
            }
            if (!Character.isDigit(digit)) {
                System.out.println("Please only enter digit, bad input: " +input);
                System.exit(1);
            }
            output[i]=digit-'0';
        }
        if (hasNegative) {
            output[0] = output[0] * -1;
        }
        return output;
    }

    public static int convert(int[] input) {
        int output = 0;
        for (int i = 0; i < input.length; i++) {
            int digit = input[i];
            if (digit < 0)
                digit = digit * -1;
            output += digit *  Math.pow(10, input.length -1 - i); 
        }
        if (input[0] < 0)
            return output * -1;
        else return output;
    }

    public static int multiply(int[] firstNumber, int[] secondNumber){
        int[] output = new int[firstNumber.length + secondNumber.length];

        boolean positiveoutput = true;
        if (firstNumber[0] * secondNumber[0] < 0) {
            positiveoutput = false;
        }
        if (firstNumber[0] < 0) {
            firstNumber[0] = firstNumber[0] * -1;
        }
        if (secondNumber[0] < 0) {
            secondNumber[0] = secondNumber[0] * -1;
        }
        for (int i = secondNumber.length -1 ; i >= 0; i--) {
            int[] tempoutput = multiply(firstNumber, secondNumber[i]);
            add(tempoutput, output, secondNumber.length - 1 - i);
        }
        int outputint = convert(output);
        if (positiveoutput) {
            return outputint;
        } else {
            return outputint * -1;
        }
    }
    
    // add input array to the output array from the index to the tail of output array
    public static void add(int[] input, int[] output, int index) {
        int carryoverdigit = 0;
        int i = output.length -1 - index;
        for (int j = input.length -1; j>=0; j--) {
            int sum = output[i] + input[j] + carryoverdigit;
            if (sum >= 10)  {
                carryoverdigit = sum / 10;
            } else {
                carryoverdigit = 0;
            }
            output[i]= sum % 10;
            i--;
        }
        if (carryoverdigit != 0) {
            output[i]= carryoverdigit;
        }
    }

    // multiply an array with another digit
    public static int[] multiply(int[] input, int multiplier) {
        int[] output = new int[input.length + 1];
        int carryoverdigit = 0;
        for (int i = input.length -1 ; i >= 0; i--) {
            int sum = input[i]*multiplier + carryoverdigit;
            if (sum >= 10)  {
                carryoverdigit = sum / 10;
            } else {
                carryoverdigit = 0;
            }
            output[i+1]= sum % 10;
        }
        if (carryoverdigit != 0) {
            output[0]= carryoverdigit;
        }
        return output;
    }
}