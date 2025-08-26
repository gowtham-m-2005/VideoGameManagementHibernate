package com.frostyFox.controller;

import java.util.Scanner;

public class InputHelper {
    Scanner scanner = new Scanner(System.in);
    public int getInt(String prompt){
        System.out.println(prompt);
        int var = scanner.nextInt();
        scanner.nextLine();

        return var;
    }

    public String getString(String prompt){
        System.out.println(prompt);
        String var = scanner.nextLine();
        return var;
    }

    public float getFloat(String prompt){
        System.out.println(prompt);
        float var = scanner.nextFloat();
        scanner.nextLine();
        return var;
    }

    public boolean getBoolean(String prompt){
        System.out.println(prompt);
        boolean var = scanner.nextBoolean();
        scanner.nextLine();
        return var;
    }

    public double getDouble(String prompt){
        System.out.println(prompt);
        double var = scanner.nextDouble();
        scanner.nextLine();
        return var;
    }
}
