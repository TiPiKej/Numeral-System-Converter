import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        List<String> ret = new ArrayList<>();

        for (String s : scanner.nextLine().split("\\s")) {
            ret.add(s);
        }

        scanner.close();

        System.out.println(ret);
    }
}