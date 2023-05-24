package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        String stringtoEncode;
        String encodedString;
        String decodedString;

        while(true) {
            System.out.println("Please input operation (encode/decode/exit):");
            input = scanner.nextLine();

            if ("exit".equals(input)){
                System.out.println("Bye!");
                break;
            }

            if ("decode".equals(input)){
                System.out.println("Input encoded string:");
                encodedString = scanner.nextLine();

                if (!Cipher.isValidEncodedString(encodedString)) {
                    System.out.println("Encoded string is not valid.");
                    continue;
                }

                decodedString = Cipher.decode(encodedString);

                System.out.println("Decoded string:");
                System.out.println(decodedString);
                continue;
            }

            if ("encode".equals(input)){
                System.out.println("Input string:");
                stringtoEncode = scanner.nextLine();

                encodedString = Cipher.encode(stringtoEncode);

                System.out.println("Encoded string:");
                System.out.println(encodedString);
                continue;
            }

            System.out.printf("There is no '%s' operation\n", input);
        }
    }

}