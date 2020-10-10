package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int nbr = scanner.nextInt();
        final int system = scanner.nextInt();
        scanner.close();

        switch (system) {
            case 2:
                System.out.println(Number.decimalToBinary(nbr));
                break;
            case 8:
                System.out.println(Number.decimalToOctal(nbr));
                break;
            case 16:
                System.out.println(Number.decimalToHexadecimal(nbr));
                break;
        }
    }
}
