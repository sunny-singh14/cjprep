package org.example.telecom;

public class Airtel implements SIM {
    @Override
    public void call() {
        System.out.println("calling from airtel");
    }

    @Override
    public void sms() {
        System.out.println("sending sms from airtel");
    }

    @Override
    public void mms() {
        System.out.println("sending mms from airtel");
    }
}
