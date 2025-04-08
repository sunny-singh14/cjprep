package org.example.thread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

    final Lock network = new ReentrantLock();
    final Lock output = new ReentrantLock();

    public void scan() {
        System.out.printf("scan waiting for network %s%n", Thread.currentThread().getName());
        network.lock();
        System.out.printf("scan acquired network %s%n", Thread.currentThread().getName());
        try {
            Thread.sleep(100);
            print();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }
    }

    public void print() {
        System.out.printf("print waiting for output %s%n", Thread.currentThread().getName());
        output.lock();
        System.out.printf("print acquired output %s%n", Thread.currentThread().getName());
        try {
            Thread.sleep(100);
            signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }
    }

    public void signal() {
        System.out.printf("signal waiting for network %s%n", Thread.currentThread().getName());
        network.lock();
        System.out.printf("signal acquired network %s%n", Thread.currentThread().getName());
    }
}
