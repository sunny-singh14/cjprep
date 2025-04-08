package org.example.thread.deadlock;

public class Main {
    public static void main(String[] args) {
        final Resource resource = new Resource();

        Thread scanning = new Thread(resource::scan);
        scanning.setName("scanning job");

        Thread printer = new Thread(resource::print);
        printer.setName("printing job");

        scanning.start();
        printer.start();
    }
}
