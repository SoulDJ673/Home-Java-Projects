package com.souldj673.basics.counting;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class RandomSums {

    //Class Accessible Scanner
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        //Random, Variable Declare/Init
        Random random = new Random();
        int currentNumber;
        boolean repeat;

        //Program run prompt
        System.out.println("Hello! I'm a huge number nerd!");
        System.out.println("I love to add in my free time.");
        System.out.println("Would you help me out by giving");
        System.out.println("me some numbers to crunch?");

        System.out.println("Help him? [y/n]");
        repeat = playPromptValidation(userInput.next());
    }
/*
    public static int adder(int[] userNums) {

    }

    /*
    This method takes the player's response and runs it through a switch-case to validate their response, 
    returning the corresponding boolean as to whether the user wants to continue the program or not.
     */
    public static boolean playPromptValidation(String answer) {
        while (true) {
            switch (answer) {
                case "y":
                case "yes":
                    return true;
                case "n":
                case "no":
                    return false;
                default:
                    System.out.println("It's a yes or no question, this isn't rocket science.");
                    System.out.println("Will you help? [y/n]");
                    answer = userInput.next();
            }
        }
    }
}
