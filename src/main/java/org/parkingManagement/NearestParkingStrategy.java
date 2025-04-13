package org.parkingManagement;

import java.util.List;

public class NearestParkingStrategy implements ParkingStrategy {

    public ParkingSpot findSpot(VehicleType v){
        List<ParkingLevel> levelList = ParkingManager.getInstance().parkingLevels;
        for(ParkingLevel l: levelList){
            List<ParkingSpot> spots = l.spots;
            for(ParkingSpot spot: spots){
                if(spot.getSpotStatus() == SpotStatus.AVAILABLE) return spot;
            }
        }
        return null;
    }

}
