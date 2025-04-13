package org.parkingManagement;

public class DefaultFeeStrategy implements FeeChargingStrategy{

    @Override
    public int calculateFee(Ticket t) {
        System.out.println("Default fee strategy");
        return 0;
    }
}
