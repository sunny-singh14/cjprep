package org.example.telecom;

public class Jio implements SIM {
    @Override
    public void call() {
        System.out.println("calling from jio");
    }

    @Override
    public void sms() {
        System.out.println("sending sms from jio");
    }
}
