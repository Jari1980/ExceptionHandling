package org.example;

public class BroccoliException extends Exception{
    private double amount;

    public BroccoliException(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
}
