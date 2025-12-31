package com.filestream.example;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWriteexample {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\jolison.e1\\Documents\\bytetest.txt");

        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            String msg = "This is simple byte stream write and read operations";
            bos.write(msg.getBytes());
            bos.flush(); // ensures everything is written
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
