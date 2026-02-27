package org.ironhack;

import java.util.Scanner;

public class TerminalReader {
    private static Scanner scanner = new Scanner(System.in);


    public static int readIntInRange(String prompt, int min, int max) {

        int input = -1;
        while (input < min || input > max) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    System.out.println("Input must be between " + min + " and " + max + ". Please try again");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return input;
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        String text= scanner.nextLine();
        while (text.trim().isEmpty()){
            System.out.println("Input cannot be empty. Please try again.");
            text= scanner.nextLine();
        }
        return text;
    }

}
