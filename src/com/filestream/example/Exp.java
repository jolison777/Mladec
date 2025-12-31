package com.filestream.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exp {

    public static void main(String[] args) {
        String path = "C:\\Users\\jolison.e1\\Documents\\chartest.txt";

        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            lines.filter(x -> x.toLowerCase().startsWith("a ")) // case-insensitive
                 .map(String::toUpperCase)
                 .forEach(System.out::println); // print each line with newline
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
