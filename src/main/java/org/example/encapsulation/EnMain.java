package org.example.encapsulation;

/**
 * Security
 * Enhancement
 * Maintainability
 * Modularity
 */
public class EnMain {
    public static void main(String[] args) {
        Angle angle = Angle.angleFromRadian(100);
        System.out.println(angle.getAngleInDegree());
        System.out.println(angle.getAngleInRadian());

        Temperature temperature = Temperature.temperatureFromDegreeC(25.0);
        System.out.println("Degree C " + temperature.getDegreeC());
        System.out.println("Degree F " + temperature.getDegreeF());
    }
}
