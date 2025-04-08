package org.example.abstaction;

public abstract class Vehical {
    int wheels;
    String engine;
    String type;

    Vehical(int wheels, String engine, String type) {
        this.wheels = wheels;
        this.engine = engine;
        this.type = type;
    }

    public int getWheels() {
        return wheels;
    }

    public Vehical setWheels(int wheels) {
        this.wheels = wheels;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public Vehical setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getType() {
        return type;
    }

    public Vehical setType(String type) {
        this.type = type;
        return this;
    }

    public abstract boolean start();

    public abstract boolean stop();
}
