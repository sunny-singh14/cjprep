package org.example.inheritance;

public class Car extends Vehical {
    public String getSubClass(){
        return this.getClass().getName();
    }
}
