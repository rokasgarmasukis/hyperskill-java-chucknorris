package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();

        char[] chars = input.toCharArray();

        String binaryString = charsIntoBinaryString(chars);

        String chuckNorrisString = binaryStringIntoChuckNorrisString(binaryString);

        printResult(chuckNorrisString);
    }

    private static String binaryStringIntoChuckNorrisString(String binaryString) {
        StringBuilder sb = new StringBuilder();

        if (binaryString.charAt(0) == '1') {
            sb.append("0 0");
        } else {
            sb.append("00 0");
        }

        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == binaryString.charAt(i - 1)) {
                sb.append("0");
            } else {
                if (binaryString.charAt(i) == '1') {
                    sb.append(" 0 0");
                } else {
                    sb.append(" 00 0");
                }
            }
        }

        return sb.toString();
    }

    private static String charsIntoBinaryString(char[] chars) {
        StringBuilder sb = new StringBuilder();
        String binary;
        String digits;
        for (char ch : chars) {
            digits = Integer.toBinaryString(ch);
            binary = String.format("%07d", Integer.parseInt(digits) );
            sb.append(binary);
        }
        return sb.toString();
    }


    private static void printResult(String output) {
        System.out.println("The result:");
        System.out.println(output);

    }



}