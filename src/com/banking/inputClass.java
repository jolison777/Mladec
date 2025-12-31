package com.banking;

import java.util.Scanner;

public class inputClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        store s1 = new store();

        char a;

      while (true) {
            System.out.println("Enter option (A=Create, B=Login, C=Transfer, D=Withdraw, E=Balance, F=Exit):");
            a = sc.next().charAt(0);

            switch (Character.toUpperCase(a)) {
                case 'A':
                    System.out.println("Enter name:");
                    String name = sc.next();
                    System.out.println("Set pin:");
                    String Pin = sc.next();
                    System.out.println("Enter the initial deposit amount:");
                    double x = sc.nextDouble();
                    Customer c1 = new Customer(name, Pin, x);
                    s1.user.put(101, c1);
                    System.out.println("Account created. Your account id is 101");
                    break;

                case 'B':
                    System.out.println("Enter name:");
                    String uname = sc.next();
                    System.out.println("Enter pin");
                    String apin = sc.next();
                    Customer d1 = s1.user.get(101);
                    if (uname.equals(d1.name) && apin.equals(d1.pin)) {
                        System.out.println("Login successful");
                    } else {
                        System.out.println("Login failed");
                    }
                    break;

                case 'C':
                	
                    System.out.println("Transfer successful");
                    break;

                case 'D':
                	System.out.println("Enter amount to withdraw");
                	
                	double amount=sc.nextDouble();
                	   
                    System.out.println("Withdraw successful");
                    break;

                case 'E':
                    System.out.println("This is your balance");
                    break;

                case 'F':
                    System.out.println("Exiting program...");
                    return; // exit main

                default:
                    System.out.println("Invalid input");
                    return;
            }
        }
    }
}
