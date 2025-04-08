package org.example.telecom;

public class SIMNotFoundException extends RuntimeException {
    SIMNotFoundException() {
        super("Please insert a sim card");
    }
}
