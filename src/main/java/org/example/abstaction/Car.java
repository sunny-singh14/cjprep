package org.example.abstaction;

import java.util.Date;

public class Car extends Vehical {

    private String model;

    private Date make;

    public Car(int wheels, String engine, String type, String model, Date make) {
        super(wheels, engine, type);
        this.model = model;
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Date getMake() {
        return make;
    }

    public Car setMake(Date make) {
        this.make = make;
        return this;
    }

    @Override
    public boolean start() {
        return false;
    }

    @Override
    public boolean stop() {
        return false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", make=" + make +
                ", wheels=" + wheels +
                ", engine='" + engine + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
