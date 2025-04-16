package org.parkingManagement;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {



    private int levelNumber;
    List<ParkingSpot> spots;
    int capacity;

    ParkingLevel(int levelNumber, int capacity){
        this.levelNumber = levelNumber;
        this.capacity = capacity;
        spots = new ArrayList<>();
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    boolean addSpot(ParkingSpot p){
        if(spots.size() < capacity){
            spots.add(p);
            return true;
        }
        return false;
    }

    boolean removeSpot(ParkingSpot p){
        if(spots.size() > 0 && spots.contains(p)){
            spots.remove(p);
            return true;
        }
        return false;
    }

}
