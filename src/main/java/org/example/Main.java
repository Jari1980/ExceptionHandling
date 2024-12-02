package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ex2();
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