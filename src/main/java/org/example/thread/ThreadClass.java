package org.example.thread;

public class ThreadClass extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("World");
        }
    }
}
