package org.parkingManagement;

public class ParkingSpot {

    int spotId;
    private SpotStatus spotStatus;
    private VehicleType vehicleType;

    ParkingSpot(int id, SpotStatus status, VehicleType type){
        this.spotId = id;
        this.spotStatus = status;
        this.vehicleType = type;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }




}
