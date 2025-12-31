package com.filestream.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharWrite {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\jolison.e1\\Documents\\chartest.txt");

        // try-with-resources ensures the writer is closed automatically
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {

            String msg = "This is a simple character stream write operation.";
            bw.write(msg);
            bw.newLine(); // adds a line break
            bw.write("Character streams handle text data efficiently.");
            bw.flush(); // pushes data to file

            System.out.println("Character write operation completed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
