package org.example.encapsulation;

public class Angle {

    private double angleInDegree;
    private double angleInRadian;

    private Angle() {
    }

    public static Angle angleFromRadian(double radian) {
        Angle a = new Angle();
        a.setAngleInRadian(radian);
        return a;
    }

    public static Angle angleFromDegree(double degree) {
        Angle a = new Angle();
        a.setAngleInDegree(degree);
        return a;
    }

    public double getAngleInDegree() {
        return angleInDegree;
    }

    public Angle setAngleInDegree(double angleInDegree) {
        this.angleInDegree = angleInDegree;
        this.angleInRadian = Math.PI * angleInDegree / 180;
        return this;
    }

    public double getAngleInRadian() {
        return angleInRadian;
    }

    public Angle setAngleInRadian(double angleInRadian) {
        this.angleInRadian = angleInRadian;
        this.angleInDegree = angleInRadian * 180 / Math.PI;
        return this;
    }
}
