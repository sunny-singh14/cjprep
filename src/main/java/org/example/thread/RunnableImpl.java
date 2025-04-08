package org.example.thread;

public class RunnableImpl implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("Other world");
        }
    }
}
