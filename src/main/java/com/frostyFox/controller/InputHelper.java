package com.frostyFox.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    Scanner scanner = new Scanner(System.in);
    public int getInt(String prompt){
        while (true){
        try {
            System.out.println(prompt);
            int var = scanner.nextInt();
            scanner.nextLine();
            return var;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number");
            scanner.nextLine();
        }
        }
    }

    public String getString(String prompt){
        System.out.println(prompt);
        String var = scanner.nextLine();
        return var;
    }

    public float getFloat(String prompt){
        while (true) {
            try {
                System.out.println(prompt);
                float var = scanner.nextFloat();
                scanner.nextLine();
                return var;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid decimal number");
                scanner.nextLine();
            }
        }
    }

    public boolean getBoolean(String prompt){
        while(true){
            try {
                System.out.println(prompt);
                boolean var = scanner.nextBoolean();
                scanner.nextLine();
                return var;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter true or false");
                scanner.nextLine();
            }
        }
    }

    public double getDouble(String prompt){
        while (true) {
            try {
                System.out.println(prompt);
                double var = scanner.nextDouble();
                scanner.nextLine();
                return var;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid decimal");
                scanner.nextLine();
            }
        }
    }
}
