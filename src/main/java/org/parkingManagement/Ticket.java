package org.parkingManagement;

import java.sql.Time;

public class Ticket {

    int ticketNumber;
    Vehicle vehicle;
    Time entryTime;
    ParkingSpot spot;

    Ticket(int ticketNumber, Vehicle vehicle, Time entryTime, ParkingSpot spot){
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.spot = spot;
    }


}
