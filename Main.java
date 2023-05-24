package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();

        char[] chars = input.toCharArray();

        printResult(chars);
    }

    private static void printResult(char[] chars) {
        System.out.println("The result:");

        String output;
        String digits;
        for (char ch : chars) {
            digits = Integer.toBinaryString(ch);
            output = String.format("%c = %07d", ch, Integer.parseInt(digits) );
            System.out.println(output);
        }
    }


}