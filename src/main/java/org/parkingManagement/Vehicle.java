package org.parkingManagement;


public class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
    Ticket ticket;

    Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}

