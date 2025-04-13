package org.parkingManagement;

public class ExitGate {

    int gateId;
    GateStatus gateStatus;

    ExitGate(int id, GateStatus status){
        this.gateId = id;
        this.gateStatus = status;
    }

    int calculateFee(Ticket t, FeeChargingStrategy s){
       return s.calculateFee(t);
    }

}
