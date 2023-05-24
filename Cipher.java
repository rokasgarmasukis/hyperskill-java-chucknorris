package chucknorris;

public class Cipher {

    static String encode(String stringToEncode) {
        String binaryString = textStringToBinaryString(stringToEncode);
        return binaryStringToCodedString(binaryString);
    }

    static String decode(String stringToDecode) {
        String binaryString = codedStringToBinaryString(stringToDecode);
        return binaryStringToTextString(binaryString);
    }

    static boolean isValidEncodedString(String encodedString) {
        // invalid if contains invalid chars
        for (int i = 0; i < encodedString.length(); i++) {
            char ch = encodedString.charAt(i);
            if (ch != ' ' && ch != '0') return false;
        }

        String[] blocks = encodedString.split(" ");

        // invalid if number of blocks is odd
        if (blocks.length % 2 != 0) return false;

        // invalid if resulting binary string would not be multiple of 7
        // lengths of second blocks of each sequence are added up
        int lengthOfBinaryString = 0;
        for (int i = 1; i < blocks.length; i += 2) {
            lengthOfBinaryString += blocks[i].length();
        }
        if (lengthOfBinaryString % 7 != 0) return false;

        // invalid if first blocks of sequences do not begin with 0 or 00
        for (int i = 0; i < blocks.length; i += 2) {
            if (!"00".equals(blocks[i]) && !"0".equals(blocks[i])) return false;
        }

        // else valid
        return true;
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
            sb.append(toAppend.repeat(codes[i + 1].length()));
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

    private static String textStringToBinaryString(String input) {
        char[] chars = input.toCharArray();
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
}
