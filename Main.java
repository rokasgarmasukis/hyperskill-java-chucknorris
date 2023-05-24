package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // System.out.println("Input string:");
        System.out.println("Input encoded string:");
        // char[] chars = input.toCharArray();

        String codedString = scanner.nextLine();

        String binaryString = codedStringToBinaryString(codedString);

        String textString = binaryStringToTextString(binaryString);

        printResult(textString);
    }

    private static String binaryStringToTextString(String binaryString) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binaryString.length(); i += 7) {
            int binary = Integer.parseInt(binaryString.substring(i, i + 7), 2);
            sb.append((char)binary);
        }

        return sb.toString();
    }

    private static String codedStringToBinaryString(String codedString) {
        String[] codes = codedString.split(" ");

        StringBuilder sb = new StringBuilder();

        String toAppend;
        for (int i = 0; i < codes.length; i += 2) {
            if (codes[i].equals("0")) {
                toAppend = "1";
            } else {
                toAppend = "0";
            }
            for (int j = 0; j < codes[i + 1].length(); j++) {
                sb.append(toAppend);
            }
        }

        return sb.toString();
    }

    private static String binaryStringToCodedString(String binaryString) {
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
            binary = String.format("%07d", Integer.parseInt(digits));
            sb.append(binary);
        }
        return sb.toString();
    }


    private static void printResult(String output) {
        System.out.println("The result:");
        System.out.println(output);

    }


}