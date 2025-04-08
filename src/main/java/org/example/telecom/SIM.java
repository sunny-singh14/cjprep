package org.example.telecom;

public interface SIM {
    void call();

    void sms();

    default void mms() {
        System.out.println("mms is not supported by your service provider");
    }
}
