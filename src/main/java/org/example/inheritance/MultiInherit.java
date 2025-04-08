package org.example.inheritance;

public class MultiInherit {
    public static void main(String[] args) {
        c3 c1 = new c1();
        c1.print();

        c3 c2 = new c2();
        c2.print();
    }
}

interface c3 {
    int num = 0;
    default void print(){
        System.out.println("default c3");
    }
    static void printStatic() {
        System.out.println("print static");
    }
}

class c1 implements c3 {
    public void print(){
        c3.super.print();
        c3.printStatic();
        int num1 = c3.num;
    }
}

class c2 implements c3 {
    public void print(){
        System.out.println("c2");
    }
}
