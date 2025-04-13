package org.parkingManagement;

import java.sql.Time;

public class EntryGate {

    int gateId;
    GateStatus gateStatus;

    EntryGate(int id, GateStatus status){
        this.gateId = id;
        this.gateStatus = status;
    }

    ParkingSpot findSpot(ParkingStrategy parkingStrategy, VehicleType v){
        return parkingStrategy.findSpot(v);
    }

    Ticket generateTicket(ParkingSpot p, Vehicle v){
        return new Ticket(TicketGenerator.generateTicketNumber(), v, new Time(System.currentTimeMillis()), p);
    }

}
