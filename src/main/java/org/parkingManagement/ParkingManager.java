package org.parkingManagement;


import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    private static ParkingManager instance;
    List<ParkingLevel> parkingLevels;
    private ParkingStrategy parkingStrategy;
    private FeeChargingStrategy feeChargingStrategy;
    private List<EntryGate> entryGate;
    private List<ExitGate> exitGate;

    private ParkingManager(){
        this.parkingStrategy = new DefaultParkingStrategy(); //default
        this.feeChargingStrategy = new DefaultFeeStrategy(); // //default
        parkingLevels = new ArrayList<>();
        entryGate = new ArrayList<>();
        exitGate = new ArrayList<>();
    }

    public static synchronized ParkingManager getInstance() {
        if(instance == null){
            instance = new ParkingManager();
        }
        return instance;
    }

    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public FeeChargingStrategy getFeeChargingStrategy() {
        return feeChargingStrategy;
    }

    public void setFeeChargingStrategy(FeeChargingStrategy feeChargingStrategy) {
        this.feeChargingStrategy = feeChargingStrategy;
    }

    void addEntryGate(EntryGate gate){
        entryGate.add(gate);
    }

    void removeEntryGate(EntryGate gate){
        entryGate.remove(gate);
    }

    void addExitGate(ExitGate gate){
        exitGate.add(gate);
    }

    void removeExitGate(ExitGate gate){
        exitGate.remove(gate);
    }

    void addLevel(ParkingLevel level){
        parkingLevels.add(level);
    }

    void removeLevel(ParkingLevel level){
        parkingLevels.remove(level);
    }

    Ticket vehicleArrives(EntryGate e, Vehicle v){
        ParkingSpot p = e.findSpot(parkingStrategy, v.vehicleType);
        markSpot(p, SpotStatus.FILLED);
        Ticket t = e.generateTicket(p, v);
        return t;
    }

    public void markSpot(ParkingSpot p, SpotStatus s){
        p.setSpotStatus(s);
    }

    int vehicleLeaves(ExitGate e, Vehicle v){
        int fee = e.calculateFee(v.ticket, feeChargingStrategy);
        markSpot(v.ticket.spot, SpotStatus.AVAILABLE);
        return fee;
    }

}

