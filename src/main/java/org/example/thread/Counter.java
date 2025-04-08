package org.example.thread;

public class Counter {
    private int count = 0;

    public synchronized void increment () {
        count++;
    }

    public int getCounter(){
        return count;
    }
}
