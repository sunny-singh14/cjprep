package org.example.constructor;

import org.example.constructor.subpack.SubTest;

public class Main extends Test {
    void Test() {
        System.out.println("constructor like method called");
    }

    Main() {
        System.out.println("Main constructor");
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        m1.Test();

        SubTest subTest = new SubTest();
    }
}
