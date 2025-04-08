package org.example.encapsulation;

public class Temperature {
    private double degreeC;
    //private double degreeF;

    private Temperature() {
    }

    public static Temperature temperatureFromDegreeC(double degreeC) {
        Temperature temperature = new Temperature();
        temperature.setDegreeC(degreeC);
        return temperature;
    }

    public static Temperature temperatureFromDegreeF(double degreeF) {
        Temperature temperature = new Temperature();
        temperature.setDegreeF(degreeF);
        return temperature;
    }

    public double getDegreeC() {
        return degreeC;
    }

    public Temperature setDegreeC(double degreeC) {
        this.degreeC = degreeC;
        //this.degreeF = (degreeC * 9 / 5) + 32;
        return this;
    }

    public double getDegreeF() {
        //return degreeF;
        return (degreeC * 9 / 5) + 32;
    }

    public Temperature setDegreeF(double degreeF) {
        //this.degreeF = degreeF;
        this.degreeC = (degreeF - 32) * 5 / 9;
        return this;
    }
}
