package org.example.telecom;

import java.util.List;

public class Customer {
    public static void main(String[] args) {
        List<Mobile> mobiles = List.of(new IPhone("Apple", "iphone 14"), new Android("Samsung", "S22 Ultra"));
        for (Mobile mobile : mobiles) {
            System.out.printf("customer is using %s %n", mobile);
            List<SIM> sims = List.of(new Jio(), new Airtel());
            for (SIM sim : sims) {
                mobile.insertSIM(sim);
                mobile.makeCall();
                mobile.sendSMS();
                mobile.sendMMS();
            }
        }
    }
}
