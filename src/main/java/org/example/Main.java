package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ex4();
    }
    public static void ex4() {
        /*
        Write a program that attempts to read a file and parse its contents as integers. Implement
        nested try-catch blocks to handle potential exceptions like NoSuchFileException, IOException and
        NumberFormatException.
         */
        var scanner = new Scanner(System.in);
        System.out.println("Do you want to check file with only integers (1), chars + integers (2), none existing file (3)? 1-3: ");
        int option = scanner.nextInt();
        Scanner instreamGood = null;
        Scanner instreamFail = null;
        try{
            instreamGood = new Scanner(new File("src/main/java/org/example/Exercise4.txt"));
        }
        catch(IOException ex1){
            System.out.println(ex1.getCause());
        }
        try{
            instreamFail = new Scanner(new File("src/main/java/org/example/Exercise4Fail.txt"));
        }
        catch(IOException ex2){
            System.out.println(ex2.getCause());
        }
        int integerRead;
        switch (option){
            case 1:
                while(instreamGood.hasNextInt()){
                    try{
                        System.out.println("Integers in file Exercise4.txt:");
                        while(instreamGood.hasNextInt()){
                            integerRead = instreamGood.nextInt();
                            System.out.println(integerRead);
                        }
                    }
                    catch(Exception e){
                        System.out.println("This should not happen");
                    }
                }
                break;
            case 2:
                try{
                    while(instreamFail.hasNextInt()){
                        System.out.println("Integers in file Exercise4Fail.txt:");
                        while(true){
                            try{
                                integerRead = instreamFail.nextInt();
                                System.out.println(integerRead);
                            }
                            catch(InputMismatchException e){
                                e.getCause();
                                System.out.println("inner error: " + e.getCause());
                                break;
                            }
                        }
                    }
                }
                catch(IllegalStateException e){
                    e.getCause();
                    System.out.println("outer error");
                }
                break;
            case 3:
                try{
                    var noFile = new Scanner(new File("src/main/java/org/example/noFile.txt"));
                    while(noFile.hasNextInt()){
                        System.out.println("Integers in file noFile.txt:");
                        while(noFile.hasNextInt()){
                            integerRead = noFile.nextInt();
                            System.out.println(integerRead);
                        }
                    }
                }
                catch(FileNotFoundException e){
                    System.out.println("This file does not exist");
                }
                break;
        }
    }

    public static void ex3(){
        /*
         Define a custom exception InsufficientBalanceException that is thrown when a withdrawal
         amount exceeds the account balance. Implement a simple banking system that allows deposits and
         withdrawals, and handles the custom exception appropriately.
         */
        System.out.println("Initiating Broccoli account: ");
        BroccoliAccount acc = new BroccoliAccount(1);
        System.out.println("Deposit 600 broccolis: ");
        acc.deposit(600);
        try{
            System.out.println("Taking 100 Broccoli: ");
            acc.withdraw(100);
            System.out.println("Taking 1000000 Broccoli: ");
            acc.withdraw(1000000);
            System.out.println("Do we get here?");
        }
        catch (BroccoliException e){
            System.out.println("Nee, not enough Broccoli, you need " + e.getAmount() + " more.");
            e.printStackTrace();
        }
    }

    public static void ex2(){
        /*
        Create a method that reads an integer from the user and checks whether it is within a certain
        range (e.g., 1 to 100). Handle exceptions for invalid inputs (e.g., non-integer input) and out-of-range
        values. */
        var scan = new Scanner(System.in);
        int num = 0;
        System.out.println("Enter a integer in the range 1-100 :");
        try{
            num = scan.nextInt();
        }
        catch(Exception e){
            throw new RuntimeException("Bad integer");
        }
        if(num < 1 || num > 100){
            throw new RuntimeException("Number out of range");
        }
        System.out.println("Good number");

    }

    public static void ex1(){
        /*
        Task: Write a program that asks the user to input two integers and then divides the first number by
        the second. Implement exception handling to manage the scenario where the user inputs zero as the
        second number.*/
        var scan = new Scanner(System.in);
        int num1 = 0;
        int num2 =  0;
        System.out.println("Enter first integer: ");
        try{
            num1 = scan.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Bad integer");
        }
        System.out.println("Enter second integer: ");
        try{
            num2 = scan.nextInt();
        }
        catch (Exception e){
            throw new RuntimeException("Bad integer");
        }
        try{
            System.out.println(num1 + " / " + num2 + " = " + num1 / num2);
        }
        catch(Exception f){
            System.out.println("Bad division");
        }
    }
}