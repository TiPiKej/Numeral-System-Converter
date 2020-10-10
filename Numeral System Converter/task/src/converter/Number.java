package converter;

public class Number {
    private static String[] arr = new String[36];

    static {
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.toString(i);
        }
        for (int i = 10; i < 36; i++) {
            arr[i] = String.valueOf((char) (i + 87));
        }
    }

    public static String decimalToBinary(int nbr) {
        return decimalToN(nbr, 2, "0b");
    }

    public static String decimalToOctal(int nbr) {
        return decimalToN(nbr, 8, "0");
    }

    public static String decimalToHexadecimal(int nbr) {
        return decimalToN(nbr, 16, "0x");
    }

    public static String decimalToN(int nbr, int N) {
        return decimalToN(nbr, N, "");
    }

    public static String decimalToN(int nbr, int N, String prefix) {
        if (N < 1 || N > 36) return null;

        final StringBuilder ret = new StringBuilder();

        while (nbr > 0) {
            if (N == 1) {
                ret.append(1);
                nbr--;
            } else {
                ret.append(arr[nbr % N]);
                nbr /= N;
            }
        }

        if (ret.length() == 0) ret.append(0);

        ret.reverse();

        ret.insert(0, prefix);
        return ret.toString();
    }

    public static int NToDecimal(String nbrRepresentation, int N) {
        int ret = 0;

        for (int i = 0; i < nbrRepresentation.length(); i++) {
            ret += indexInArr(nbrRepresentation.charAt(nbrRepresentation.length() - 1 - i)) * Math.pow(N, i);
        }

        return ret;
    }

    private static int indexInArr(char c) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == c) return i;
        }

        return -1;
    }

    public static int binaryToDecimal(String binary) {
        int nbr = 0;

//        binary representation 0bxxx
        for (int i = 2; i < binary.length(); i++) {
            if (binary.charAt(binary.length() - i - 1) == '1') nbr += Math.pow(2, i);
        }

        return nbr;
    }

    public static int octalLastDigit(int decimal) {
        return decimal % 8;
    }
}
