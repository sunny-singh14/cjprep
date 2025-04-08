package org.example.telecom;

public class IPhone extends Mobile {
    private final String model;

    IPhone(String brand, String model) {
        super(brand);
        this.model = model;
    }

    @Override
    public void sendMMS() {
        assertSIMAvailable();
        sim.mms();
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
