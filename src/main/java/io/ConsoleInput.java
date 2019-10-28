package io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scn;

    public ConsoleInput() {
        scn = new Scanner(System.in);
    }

    @Override
    public int takeOrderQuantity() {
        int result;
        try {
            result = scn.nextInt();
            return result;
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input");
            scn.nextLine();
        }
        return takeOrderQuantity();
    }

    @Override
    public String takeUserDetails() {
        return scn.nextLine();
    }
}