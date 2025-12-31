package com.Generics.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Immutable class
final class testImmutable {
    private final String msg = "hello hi bye";
    private final List<String> names = Arrays.asList("King");

    public testImmutable() {
        // Constructor does not allow modification
    }

    public String getMsg() {
        return msg;
    }

    // Returns the original list (modifiable reference, not safe)
    public List<String> getNames() {
        return names;
    }

    // Returns an unmodifiable view of the list (safe)
    public List<String> getListNames() {
        return Collections.unmodifiableList(names);
    }
}

// Demo class
public class CustomInmutable {
    public static void main(String[] args) {
        testImmutable obj = new testImmutable();

        // Access immutable fields
        System.out.println("Message: " + obj.getMsg());

        // Access names list directly
        System.out.println("Names (direct): " + obj.getNames());

        // Access names list safely (unmodifiable)
        List<String> safeList = obj.getListNames();
        System.out.println("Names (safe): " + safeList);

        // Try modifying safeList (will throw UnsupportedOperationException)
        try {
            safeList.add("Queen");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify safe list: " + e);
        }

        // Try modifying original list (possible, but breaks immutability)
        List<String> directList = obj.getNames();
        directList.set(0, "Prince");
        System.out.println("Names after direct modification: " + directList);
    }
}
