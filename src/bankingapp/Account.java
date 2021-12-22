/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapp;

import java.util.Scanner;

/**
 *
 * @author Nathan Daniel
 */
public class Account {
    private  String name;
    private String customerID;
    private static int balance = 0;
    Scanner scan = new Scanner(System.in);
    public Account(String name,String customerID){
     this.name = name;
     this.customerID = customerID;}
     
    public void getBalance(){
         System.out.println("$" + this.balance);
     }
    public void calculateInterest(int years){
         double interestRate = .0185;
         double newBalance = (balance * interestRate * years) + balance;
	 System.out.println("The current interest rate is " + (100 * interestRate) + "%");
         System.out.println("After " + years + " years, your balance will be: $" + newBalance);
    }
    public void deposit(int deposit){
        
         System.out.println("You have deposited $" + deposit + " into your account");
         balance+=deposit;
         System.out.println("Your current balance is $" + balance);
    }
      public void withdraw(int withdraw){
         
         System.out.println("You have withdrawn $" + withdraw + " from your account");
         balance -= withdraw;
         System.out.println("Your current balance is $" + balance);
    }
      public void menu(){
            System.out.println("Welcome, " + name + "!");
            System.out.println("id: " + customerID + "\n");
            System.out.println("What would you like to do?");
            
            System.out.println("A. Check your balance");
            System.out.println("B. Make a deposit");
            System.out.println("C. Make a withdrawal");
            System.out.println("D. Calculate interest");
            System.out.println("E. Exit\n\n");
          while(true){
           
            System.out.println("Enter an option:");
            
            char input = scan.next().charAt(0);
            
            switch(input){
                
                case 'A':
                    getBalance();
                    break;
                case 'B':
                    System.out.println("Enter amount of money you would like to deposit");
                    int deposit = scan.nextInt();
                    deposit(deposit);
                    break;
                case 'C':
                    System.out.println("Enter amount of money you would like to withdraw");
                    int withdraw = scan.nextInt();
                    if(withdraw>balance){
                    
                        System.out.println("Insufficient funds");}
                    else{ 
                    withdraw(withdraw);}
                    break;
                case 'D':
                    System.out.println("Enter years");
                    int years = scan.nextInt();
                    calculateInterest(years);
                    break;
                case 'E':
                    System.exit(0);
                    
            }
        }
      }
}
