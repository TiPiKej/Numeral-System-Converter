package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int srcRadix = Integer.parseInt(scanner.nextLine());
        final String srcNumber = scanner.nextLine();
        final int tgRadix = Integer.parseInt(scanner.nextLine());
        scanner.close();

        int decimal = Number.NToDecimal(srcNumber, srcRadix);

        System.out.println(Number.decimalToN(decimal, tgRadix));
    }
}
