package org.example.lambdas;

@java.lang.FunctionalInterface
public interface FunctionalInterface {
    void run();

    static void run1() {

    }

    default void run2(){

    }

    private void run3(){}
}
