package org.example;

public class BroccoliAccount {
    private double balance;
    private int number;

    public BroccoliAccount(int number){
        this.number = number;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount) throws BroccoliException{
        if(amount <= balance){
            balance -= amount;
        }
        else{
            double needs = amount - balance;
            throw new BroccoliException(needs);
        }
    }
    public double getBalance() {
        return balance;
    }
    public int getNumber() {
        return number;
    }
}
