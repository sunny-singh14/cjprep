package org.example.abstaction;

import java.util.Date;

public class AbMain {
    public static void main(String[] args) {
        Car f1 = new Car(4, "v8", "race", "f12024", new Date());
        System.out.println(f1);

        /**
         * Anonymous Subclass Creation: When you write new Vehical(...) { ... }, you're telling Java to create a new, unnamed subclass of Vehical. This subclass immediately implements the abstract methods (start() and stop()) required by Vehical.
         * Instantiation of the Subclass: You then instantiate this new subclass—not Vehical itself. The code only instantiates an object of this subclass that fulfills all requirements of the abstract class, making it valid.
         * So, in essence, you're not instantiating Vehical directly. Instead, Java creates a hidden subclass of Vehical on the spot and instantiates that subclass. This approach allows you to leverage the functionality of abstract classes while still adhering to the rule that abstract classes cannot be directly instantiated.
         */
        Vehical v = new Vehical(4, "v8", "race") {
            @Override
            public boolean start() {
                return false;
            }

            @Override
            public boolean stop() {
                return false;
            }
        };

        System.out.println(v);
    }
}
