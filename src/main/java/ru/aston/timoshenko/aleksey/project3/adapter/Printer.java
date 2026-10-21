package ru.aston.timoshenko.aleksey.project3.adapter;

import java.io.*;

public class Printer {

    public void printSomething(String something) {
        try (BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out))) {
            bw.write(something);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
