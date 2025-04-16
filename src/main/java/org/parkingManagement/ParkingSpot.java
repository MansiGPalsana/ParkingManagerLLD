package org.parkingManagement;

public class ParkingSpot {

    private int spotId;
    private SpotStatus spotStatus;
    private VehicleType vehicleType;

    ParkingSpot(int id, SpotStatus status, VehicleType type){
        this.spotId = id;
        this.spotStatus = status;
        this.vehicleType = type;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }
    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }




}
