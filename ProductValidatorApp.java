package com.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductValidatorApp {

    static class SerialNumberException extends Exception {
        SerialNumberException(String message) { super(message); }
    }

    static class PriceFormatException extends Exception {
        PriceFormatException(String message) { super(message); }
    }

    public static void main(String[] args) {

        final String serialRegex = "^[A-Z]{2,4}-\\d{3,5}$"; // allows 2–4 letters and 3–5 digits
        final Pattern serialPatternObj = Pattern.compile(serialRegex);

        final String priceRegex = "^[₹\\$\\€]\\d+(\\.\\d{2})$"; // supports ₹, $, €
        final Pattern pricePatternObj = Pattern.compile(priceRegex);

        try (Scanner inputScanner = new Scanner(System.in)) {

            System.out.print("Enter Product Serial Number (e.g., ABCD-1234): ");
            String enteredSerial = inputScanner.nextLine().trim();

            try {
                checkSerialNumber(enteredSerial, serialPatternObj);
                System.out.println("✅ Serial number format is valid.");
            } catch (SerialNumberException e) {
                System.out.println(" Inventory Error: " + e.getMessage());
                return;
            }

            System.out.print("Enter Product Price (e.g., ₹199.99): ");
            String enteredPrice = inputScanner.nextLine().trim();

            try {
                checkPriceFormat(enteredPrice, pricePatternObj);
                System.out.println(" Price entry is valid.");
            } catch (PriceFormatException e) {
                System.out.println(" Pricing Error: " + e.getMessage());
            }
        }
    }

    private static void checkSerialNumber(String serial, Pattern pattern) throws SerialNumberException {
        Matcher matcher = pattern.matcher(serial);
        if (!matcher.matches()) {
            throw new SerialNumberException(
                "Serial must start with 2–4 uppercase letters, a hyphen, and 3–5 digits."
            );
        }
    }

    private static void checkPriceFormat(String price, Pattern pattern) throws PriceFormatException {
        Matcher matcher = pattern.matcher(price);
        if (!matcher.matches()) {
            throw new PriceFormatException(
                "Price must start with ₹ and include exactly two decimal places."
            );
        }
    }
}
