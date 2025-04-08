package org.example.thread;

public class Main {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("Hello World!")).start();
    }
}
