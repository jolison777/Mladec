package com.EmployeeManagementEx;

import java.util.Scanner;

public class EmployeeManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDao dao = new EmployeeDaoImpl();

        while (true) {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(id, name, dept, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter New Department: ");
                    String udept = sc.nextLine();
                    System.out.print("Enter New Salary: ");
                    double usalary = sc.nextDouble();
                    Employee updated = dao.updateEmployee(new Employee(uid, uname, udept, usalary));
                    if (updated != null) {
                        System.out.println("Employee updated: " + updated);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteEmployee(did);
                    System.out.println("Employee deleted if existed.");
                    break;

                case 4:
                    System.out.println("All Employees:");
                    for (Employee e : dao.getAllEmployees()) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
