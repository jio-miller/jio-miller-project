package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public void clearCache() {
        scanner.nextLine();
    }

    public String getString() {
        return scanner.nextLine();
    }

    public boolean yesNo() {
        String input = getString();
        return input.equalsIgnoreCase("y")
                || input.equalsIgnoreCase("yes")
                || input.equalsIgnoreCase("sure");
    }


    public int getInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Input has to be a number.");
            scanner.nextLine();
            return getInt();
        }
    }

    public int getInt(int min) {
        int res = getInt();
        if (res < min) {
            System.out.printf("Input must be above %d\n", min);
            return getInt(min);
        }
        return res;
    }

    public int getInt(int min, int max) {
        int result = getInt();
        if (result < min || result > max) {
            System.err.printf("Input has to be between %d and %d\n", min, max);
            return getInt(min, max);
        }
        return result;
    }

    public double getDouble() {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("Input has to be a number.");
            scanner.nextLine();
            return getDouble();
        }
    }

    public double getDouble(double min, double max) {
        double result = getDouble();
        if (result < min || result > max) {
            System.err.printf("Input has to be between %.1f and %.1f\n", min, max);
            return getDouble(min, max);
        }
        return result;
    }

}
