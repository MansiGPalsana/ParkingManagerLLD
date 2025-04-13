package org.parkingManagement;

import java.sql.Time;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello and welcome!");
        ParkingManager manager = ParkingManager.getInstance();
        manager.setParkingStrategy(new NearestParkingStrategy());
        manager.setFeeChargingStrategy(new HourlyFeeStrategy(10));

        EntryGate entryGate = new EntryGate(1, GateStatus.OPEN);
        ExitGate exitGate = new ExitGate(1, GateStatus.OPEN);

        manager.addEntryGate(entryGate);
        manager.addExitGate(exitGate);

        ParkingLevel p1 = new ParkingLevel(1, 5);

        p1.addSpot(new ParkingSpot(1, SpotStatus.AVAILABLE, VehicleType.FOUR_WHEELER));
        p1.addSpot(new ParkingSpot(2, SpotStatus.AVAILABLE, VehicleType.FOUR_WHEELER));
        p1.addSpot(new ParkingSpot(3, SpotStatus.AVAILABLE, VehicleType.FOUR_WHEELER));
        p1.addSpot(new ParkingSpot(4, SpotStatus.AVAILABLE, VehicleType.TWO_WHEELER));
        p1.addSpot(new ParkingSpot(5, SpotStatus.AVAILABLE, VehicleType.TWO_WHEELER));


        ParkingLevel p2 = new ParkingLevel(1, 5);

        p2.addSpot(new ParkingSpot(1, SpotStatus.AVAILABLE, VehicleType.FOUR_WHEELER));
        p2.addSpot(new ParkingSpot(2, SpotStatus.AVAILABLE, VehicleType.FOUR_WHEELER));
        p2.addSpot(new ParkingSpot(3, SpotStatus.AVAILABLE, VehicleType.FOUR_WHEELER));
        p2.addSpot(new ParkingSpot(4, SpotStatus.AVAILABLE, VehicleType.TWO_WHEELER));
        p2.addSpot(new ParkingSpot(5, SpotStatus.AVAILABLE, VehicleType.TWO_WHEELER));

        manager.addLevel(p1);
        manager.addLevel(p2);

        Vehicle v1 = new Vehicle("GJ061234", VehicleType.FOUR_WHEELER);
        Ticket t1 = manager.vehicleArrives(entryGate, v1);
        v1.setTicket(t1);

        Vehicle v2 = new Vehicle("GJ061235", VehicleType.TWO_WHEELER);
        Ticket t2 = manager.vehicleArrives(entryGate, v2);
        v2.setTicket(t2);

        Thread.sleep(5000);
        int fee1 = manager.vehicleLeaves(exitGate, v1);
        System.out.println(fee1);

        Thread.sleep(5000);
        int fee2 = manager.vehicleLeaves(exitGate, v2);
        System.out.println(fee2);

    }
}

