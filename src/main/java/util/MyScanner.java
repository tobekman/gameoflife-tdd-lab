package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static int intScanner() {
        boolean loop = true;
        int choice = 0;
        while(loop) {
            try {
                choice = scanner.nextInt();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.print("Provide a number: ");
            } finally {
                scanner.nextLine();
            }
        }
        return choice;
    }
}