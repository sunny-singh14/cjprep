package org.example.inheritance;

public class InMain {
    public static void main(String[] args) {
        // with parent class can't call base class method
        Vehical v1 = new Vehical();
        v1.getSuperClass();

        // with parent class ref we can hold sub class instance
        Vehical v = new Car();
        v.getSuperClass();
        // with parent class ref we can't call sub class method even if its base class instance
        // v.getSubClass();

        // with sub class ref we can call both super class and sub class method
        
        Car c = new Car();
        c.getSuperClass();
        c.getSubClass();
        //private method/members are not available
        //c.wheel;

        AbSuper abSuper= new ConcSub();
        
    }
}
