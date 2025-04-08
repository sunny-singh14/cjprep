package org.example.telecom;

public class Android extends Mobile {
    private final String model;

    Android(String brand, String model) {
        super(brand);
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void sendMMS() {
        System.out.println("mms feature not supported");
    }
}
