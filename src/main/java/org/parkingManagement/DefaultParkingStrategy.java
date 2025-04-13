package org.parkingManagement;

public class DefaultParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findSpot(VehicleType v) {
        System.out.println("Default parking strategy");
        return null;
    }
}
