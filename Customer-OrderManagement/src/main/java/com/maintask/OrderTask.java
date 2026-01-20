
package com.maintask;

import com.dao.OrderDao;
import com.daoimpl.OrderDaoImpl;
import com.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OrderTask {
    public static void main(String[] args) {
        OrderDao dao = new OrderDaoImpl();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Order Management ===");  
                System.out.println("1. Add Order");
                System.out.println("2. Update Order");
                System.out.println("3. Delete Order");
                System.out.println("4. Read Order(s)");
                System.out.println("5. Bulk Add Orders");
                System.out.println("0. Exit");
                System.out.print("Choose option: ");
                String choice = sc.nextLine().trim();

                switch (choice) {
                    case "1":
                        addOrder(sc, dao);
                        break;
                    case "2":
                        updateOrder(sc, dao);
                        break;
                    case "3":
                        deleteOrder(sc, dao);
                        break;
                    case "4":
                        readOrders(sc, dao);
                        break;
                    case "5":
                        bulkAdd(sc, dao);
                        break;
                    case "0":
                        System.out.println("Bye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private static void addOrder(Scanner sc, OrderDao dao) {
        String name = prompt(sc, "Customer name");
        int amount = parseInt(prompt(sc, "Total amount (int)"));
        Order o = new Order(name, amount);
        try {
            Order saved = dao.add(o);
            System.out.println("Added: ID=" + saved.getId());
        } catch (Exception e) {
            System.out.println("Add failed: " + e.getMessage());
        }
    }

    private static void updateOrder(Scanner sc, OrderDao dao) {
        Long id = parseLong(prompt(sc, "Order ID to update"));
        String name = prompt(sc, "New customer name");
        int amount = parseInt(prompt(sc, "New total amount (int)"));
        Order incoming = new Order(name, amount);
        try {
            Order updated = dao.update(id, incoming);
            System.out.println("Updated: ID=" + updated.getId());
        } catch (Exception e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    private static void deleteOrder(Scanner sc, OrderDao dao) {
        Long id = parseLong(prompt(sc, "Order ID to delete"));
        try {
            dao.delete(id);
            System.out.println("Deleted: ID=" + id);
        } catch (Exception e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }

    private static void readOrders(Scanner sc, OrderDao dao) {
        String type = prompt(sc, "Read (A)ll or (O)ne?");
        if (type.equalsIgnoreCase("A")) {
            List<Order> list = dao.getAll();
            System.out.println("Orders (" + list.size() + "):");
            list.forEach(o ->
                System.out.println(o.getId() + " | " + o.getCustomerName() + " | " + o.getTotalAmount()));
        } else {
            Long id = parseLong(prompt(sc, "Order ID"));
            Optional<Order> found = dao.get(id);  // <-- com.entity.Order
            if (found.isPresent()) {
                Order o = found.get();
                System.out.println(o.getId() + " | " + o.getCustomerName() + " | " + o.getTotalAmount());
            } else {
                System.out.println("Order not found: " + id);
            }
        }
    }

    private static void bulkAdd(Scanner sc, OrderDao dao) {
        int count = parseInt(prompt(sc, "How many orders to add?"));
        List<Order> orders = new java.util.ArrayList<>(count);
        for (int i = 1; i <= count; i++) {
            System.out.println("Entry #" + i);
            String name = prompt(sc, "Customer name");
            int amount = parseInt(prompt(sc, "Total amount (int)"));
            orders.add(new Order(name, amount));
        }
        try {
            dao.addAll(orders);
            System.out.println("Bulk added: " + orders.size());
        } catch (Exception e) {
            System.out.println("Bulk add failed: " + e.getMessage());
        }
    }

    private static String prompt(Scanner sc, String label) {
        System.out.print(label + ": ");
        return sc.nextLine().trim();
    }

    private static int parseInt(String s) {
        try {
            int val = Integer.parseInt(s);
            if (val <= 0) throw new NumberFormatException("Amount must be > 0");
            return val;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid integer: " + s + " (" + e.getMessage() + ")");
        }
    }

    private static Long parseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid ID: " + s);
        }
    }
}
