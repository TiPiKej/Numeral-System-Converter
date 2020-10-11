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
        return decimalToN(Integer.toString(nbr), 2, "0b");
    }

    public static String decimalToOctal(int nbr) {
        return decimalToN(Integer.toString(nbr), 8, "0");
    }

    public static String decimalToHexadecimal(int nbr) {
        return decimalToN(Integer.toString(nbr), 16, "0x");
    }

    public static String decimalToN(String nbr, int N) {
        return decimalToN(nbr, N, "");
    }

    public static String decimalToN(String nbr, int N, String prefix) {
        if (N < 1 || N > 36) return null;

        final StringBuilder ret = new StringBuilder();

        String[] parts = nbr.split("\\.");

//        first part
        int firstPart = Integer.parseInt(parts[0]);
        while (firstPart > 0) {
            if (N == 1) {
                ret.append(1);
                firstPart--;
            } else {
                ret.append(arr[firstPart % N]);
                firstPart /= N;
            }
        }

        if (ret.length() == 0) ret.append(0);

        ret.reverse();

        ret.insert(0, prefix);

        if (parts.length < 2) return ret.toString();

        ret.append(".");

//        second part
        double secondPart = Double.parseDouble(nbr) - Integer.parseInt(parts[0]);
        for (int i = 0; i < 5; i++) {
            secondPart *= N;


            int fractional = Integer.parseInt(Double.toString(secondPart).split("\\.")[0]);

            ret.append(arr[fractional]);
            secondPart -= fractional;
        }

        return ret.toString();
    }

    public static String NToDecimal(String nbrRepresentation, int N) {
        String[] nbrParts = nbrRepresentation.split("\\.");

        int ret = 0;

        for (int i = 0; i < nbrParts[0].length(); i++) {
            ret += indexInArr(nbrParts[0].charAt(nbrParts[0].length() - 1 - i)) * Math.pow(N, i);
        }

        if (nbrParts.length < 2) return Integer.toString(ret);

        double retDouble = ret;

        for (int i = 0; i < nbrParts[1].length(); i++) {
            retDouble += indexInArr(nbrParts[1].charAt(i)) / Math.pow(N, i + 1);
        }

        return Double.toString(retDouble);
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

    public static String NToN(String nbr, int srcRadix, int tgRadix) {
        return Number.decimalToN(Number.NToDecimal(nbr, srcRadix), tgRadix);
    }
}
