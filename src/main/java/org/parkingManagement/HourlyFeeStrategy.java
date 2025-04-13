package org.parkingManagement;

public class HourlyFeeStrategy implements FeeChargingStrategy{

    int hourlyRate;

    HourlyFeeStrategy(int rate){
        this.hourlyRate = rate;
    }

    @Override
    public int calculateFee(Ticket t) {
        long elapsedTimeMillis = System.currentTimeMillis() - t.entryTime.getTime();
        long elapsedSec = elapsedTimeMillis / (1000);
        int hourlyRate = 10;
        return (int) elapsedSec * hourlyRate;
    }
}
