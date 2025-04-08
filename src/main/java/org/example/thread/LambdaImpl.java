package org.example.thread;

public class LambdaImpl {
    public static void main(String[] args) {
        Thread greet = new Thread(() -> {
            System.out.println("Welcome");
            System.out.println("Hello World");
        });
        greet.start();
    }
}
