package org.example.oop;

public interface InterfaceTest {
    default void say(){
        System.out.println("saying");
    }

    default void silent(){
        say();
    }
}

interface Sub extends InterfaceTest {
    @Override
    default void say() {
        InterfaceTest.super.say();
    }
}

interface InterfaceA {
    default void display() {
        System.out.println("InterfaceA display");
    }

    void say();
}

interface InterfaceB {
    int a = 1;
    default void display() {
        System.out.println(a);
        System.out.println("InterfaceB display");
        some();
    }

    void say();

    static private void some(){
        System.out.println(a);
    }
}

class MyClass implements InterfaceA, InterfaceB {

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.display();  // Output: "InterfaceA display" or "MyClass display" depending on the implementation
    }

    @Override
    public void display() {
        InterfaceA.super.display();
    }

    @Override
    public void say() {

    }
}

