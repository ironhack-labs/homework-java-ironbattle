package com.ironhack.io;

import java.util.Scanner;

public class InputHandler {
    private final static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static int readIntInRange(String prompt, int min, int max) {
        int value = -1;
        while (value < min || value > max) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                if (value < min || value > max) {
                    System.out.println("Value must be between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
        return value;
    }
}
