package org.example.telecom;

public abstract class Mobile {
    private final String brand;

    protected SIM sim;

    Mobile(String brand) {
        this.brand = brand;
    }

    public void insertSIM(SIM sim) {
        System.out.printf("New sim detected %s%n", sim.getClass().getSimpleName());
        this.sim = sim;
    }

    public String getBrand() {
        return this.brand;
    }

    public abstract String getModel();

    public void makeCall() {
        assertSIMAvailable();
        sim.call();
    }

    public void sendSMS() {
        assertSIMAvailable();
        sim.sms();
    }

    public abstract void sendMMS();

    protected void assertSIMAvailable() {
        if (sim == null) {
            throw new SIMNotFoundException();
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", getBrand(), getModel());
    }
}
