package org.parkingManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ParkingManager {
    private static final Logger logger = Logger.getLogger(ParkingManager.class.getName()); // Logger instance

    private static ParkingManager instance;
    List<ParkingLevel> parkingLevels;
    private ParkingStrategy parkingStrategy;
    private FeeChargingStrategy feeChargingStrategy;
    private List<EntryGate> entryGate;
    private List<ExitGate> exitGate;

    private ParkingManager() {
        logger.info("Initializing ParkingManager...");
        this.parkingStrategy = new DefaultParkingStrategy(); // default
        this.feeChargingStrategy = new DefaultFeeStrategy(); // default
        parkingLevels = new ArrayList<>();
        entryGate = new ArrayList<>();
        exitGate = new ArrayList<>();
        logger.info("ParkingManager initialized.");
    }

    public static synchronized ParkingManager getInstance() {
        logger.info("Fetching ParkingManager instance...");
        if (instance == null) {
            logger.info("Creating new ParkingManager instance.");
            instance = new ParkingManager();
        }
        return instance;
    }

    public ParkingStrategy getParkingStrategy() {
        logger.info("Getting ParkingStrategy...");
        return parkingStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        logger.info("Setting ParkingStrategy: " + parkingStrategy.getClass().getName());
        this.parkingStrategy = parkingStrategy;
    }

    public FeeChargingStrategy getFeeChargingStrategy() {
        logger.info("Getting FeeChargingStrategy...");
        return feeChargingStrategy;
    }

    public void setFeeChargingStrategy(FeeChargingStrategy feeChargingStrategy) {
        logger.info("Setting FeeChargingStrategy: " + feeChargingStrategy.getClass().getName());
        this.feeChargingStrategy = feeChargingStrategy;
    }

    void addEntryGate(EntryGate gate) {
        logger.info("Adding EntryGate: " + gate.gateId);
        entryGate.add(gate);
    }

    void removeEntryGate(EntryGate gate) {
        logger.info("Removing EntryGate: " + gate.gateId);
        entryGate.remove(gate);
    }

    void addExitGate(ExitGate gate) {
        logger.info("Adding ExitGate: " + gate.gateId);
        exitGate.add(gate);
    }

    void removeExitGate(ExitGate gate) {
        logger.info("Removing ExitGate: " + gate.gateId);
        exitGate.remove(gate);
    }

    void addLevel(ParkingLevel level) {
        logger.info("Adding ParkingLevel: " + level.getLevelNumber());
        parkingLevels.add(level);
    }

    void removeLevel(ParkingLevel level) {
        logger.info("Removing ParkingLevel: " + level.getLevelNumber());
        parkingLevels.remove(level);
    }

    Ticket vehicleArrives(EntryGate e, Vehicle v) {
        logger.info("Vehicle arrives at EntryGate: " + e.gateId + ", Vehicle: " + v.vehicleType);
        ParkingSpot p = e.findSpot(parkingStrategy, v.vehicleType);
        markSpot(p, SpotStatus.FILLED);
        Ticket t = e.generateTicket(p, v);
        logger.info("Ticket generated: " + t.ticketNumber);
        return t;
    }

    public void markSpot(ParkingSpot p, SpotStatus s) {
        logger.info("Marking ParkingSpot: " + p.getSpotId() + " as " + s);
        p.setSpotStatus(s);
    }

    int vehicleLeaves(ExitGate e, Vehicle v) {
        logger.info("Vehicle leaves from ExitGate: " + e.gateId + ", Vehicle: " + v.vehicleType);
        int fee = e.calculateFee(v.ticket, feeChargingStrategy);
        logger.info("Fee calculated: " + fee);
        markSpot(v.ticket.spot, SpotStatus.AVAILABLE);
        return fee;
    }
}