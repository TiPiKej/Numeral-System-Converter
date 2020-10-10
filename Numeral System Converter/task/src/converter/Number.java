package converter;

public class Number {
    public static String decimalToBinary(int nbr) {
        final StringBuilder ret = new StringBuilder();

        while (nbr > 0) {
            ret.append(nbr % 2);
            nbr /= 2;
        }

        if (ret.length() == 0) ret.append(0);

        ret.append("b0");

        ret.reverse();
        return ret.toString();
    }

    public static String decimalToOctal(int nbr) {
        final StringBuilder ret = new StringBuilder();

        while (nbr > 0) {
            ret.append(nbr % 8);
            nbr /= 8;
        }

        if (ret.length() == 0) ret.append(0);

        ret.append("0");

        ret.reverse();
        return ret.toString();
    }

    public static String decimalToHexadecimal(int nbr) {
        final StringBuilder ret = new StringBuilder();
        String[] arr = new String[16];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.toString(i);
        }
        for (int i = 10; i <= 15; i++) {
            arr[i] = String.valueOf((char) (i + 87));
        }

        while (nbr > 0) {
            ret.append(arr[nbr % 16]);
            nbr /= 16;
        }

        if (ret.length() == 0) ret.append(0);

        ret.append("x0");

        ret.reverse();
        return ret.toString();
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
