package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String srcRadix = "";
        String srcNumber = "";
        String tgRadix = "";

        boolean isError = false;

        if (scanner.hasNextLine()) srcRadix = scanner.nextLine();
        else isError = true;

        if (scanner.hasNextLine()) srcNumber = scanner.nextLine();
        else isError = true;

        if (scanner.hasNextLine()) tgRadix = scanner.nextLine();
        else isError = true;

        if (!srcRadix.matches("\\d+")) isError = true;
        if (!srcNumber.matches("[a-z0-9.]+")) isError = true;
        if (!tgRadix.matches("\\d+")) isError = true;

        scanner.close();

        if (!isError) {
            if (Integer.parseInt(srcRadix) <= 0 || Integer.parseInt(srcRadix) > 36) isError = true;
            if (Integer.parseInt(tgRadix) <= 0 || Integer.parseInt(tgRadix) > 36) isError = true;
        }

        if (isError) System.out.println("error");
        else System.out.println(Number.NToN(srcNumber, Integer.parseInt(srcRadix), Integer.parseInt(tgRadix)));
    }
}
