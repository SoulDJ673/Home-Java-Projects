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

    //Game Properties
    private static int sum = 0;
    private static boolean repeat;

    public static void main(String[] args) {
        //Program run prompt
        System.out.println("Hello! I'm a huge number nerd!");
        System.out.println("I love to add in my free time.");
        System.out.println("Would you help me out by giving");
        System.out.println("me some numbers to crunch?");

        System.out.println("Help him? [y/n]");
        repeat = playPromptValidation(userInput.next());

        //End game if no
        if (!repeat) {
            return;
        } else {
        }

        System.out.println("I'll start with " + adder(cpuNum()));
        System.out.print("What number is next? ");
        adder(userInput.nextInt());

        restOfGame();
        
        System.out.println("Thanks for helping!");
        System.out.println("We ended at " + sum);

    }

    //This method takes numbers and sums them together
    public static int adder(int num) {
        sum += num;
        return sum;
    }

    /*
    This method takes the player's response and runs it through a switch-case to validate their response, 
    returning the corresponding boolean as to whether the user wants to continue the program or not.
     */
    public static boolean playPromptValidation(String answer) {
        while (true) {
            switch (answer.toLowerCase()) {
                case "y":
                case "yes":
                    return true;
                case "n":
                case "no":
                    return false;
                default:
                    System.out.println("It's a yes or no question, this isn't rocket science.");
                    System.out.println("Answer [y/n]");
                    answer = userInput.next();
            }
        }
    }

    //This method returns a randomly generated number
    public static int cpuNum() {
        //Random Declare/Init
        Random random = new Random();

        return random.nextInt(101);
    }

    //This method contains the repeating prompt that is the game
    public static void restOfGame() {
        while (repeat) {
            System.out.println("\nGreat! The sum is now at " + sum);

            System.out.print("Do you want to continue? [y/n] ");
            repeat = playPromptValidation(userInput.next());
            if (!repeat) {
                return;
            } else {
            }
            int cpuNumber;
            cpuNumber = cpuNum();
            System.out.println("I'll add " + cpuNumber + " so now our total is " + adder(cpuNumber));
            
            System.out.print("Which number will you add? ");
            adder(userInput.nextInt());
        }
    }
}
