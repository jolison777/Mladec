package com.test;

import java.time.LocalDateTime;

public class timestampsgltontask {

    private static timestampsgltontask instance;
    private final LocalDateTime createdAt;

    private timestampsgltontask() {
        createdAt = LocalDateTime.now();
    }

    public static synchronized timestampsgltontask getInstance() {
        if (instance == null) {
            instance = new timestampsgltontask();
        }
        return instance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static void main(String[] args) {
        timestampsgltontask s1 = timestampsgltontask.getInstance();
        System.out.println("First instance created at: " + s1.getCreatedAt());

        timestampsgltontask s2 = timestampsgltontask.getInstance();
        System.out.println("Second instance created at: " + s2.getCreatedAt());

        System.out.println("Same instance? " + (s1 == s2));
    }
}

