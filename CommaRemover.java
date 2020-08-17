import java.util.Scanner;

public class CommaRemover {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("input an interger between 1000 and 999,999");
        final String input = sc.next();
        final int length = input.length();
        final String part1 = input.substring(0,length-4);
        final String part2 = input.substring(length-3);
        final String result = part1 + part2;
        System.out.println(result);
    }
}
