package org.example.oop;


// can we override static method?

public class OverrideCheck {
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        Child obj2 = new Child();

        obj1.show();
        obj2.show();
    }
}

class Parent {
    static void show() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Static method in Child");
    }
}
