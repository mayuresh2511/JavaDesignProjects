package com.maymar.entitty;

import com.maymar.parkingLotCore.Bill;
import com.maymar.parkingLotCore.EntryGate;
import com.maymar.parkingLotCore.ExitGate;
import com.maymar.parkingLotCore.constants.VehicleType;
import com.maymar.parkingLotCore.impls.ParkingSpot;
import com.maymar.parkingLotCore.interfaces.ParkingTicketInterface;

public class Vehicle {

    private final VehicleType vehicleType;
    private final String vehicleNumber;
    private ParkingTicketInterface ticket;
    private ParkingSpot parkingSpot;
    public Vehicle(VehicleType vehicleType,
                   String vehicleNumber) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public ParkingTicketInterface getTicket() {
        return ticket;
    }
    public void setParkingTicket(ParkingTicketInterface parkingTicket){
        this.ticket = parkingTicket;
    }
    public void enterInParkingLot(EntryGate entryGate1){
        parkingSpot = entryGate1.assignEntryVehicle(this);
        parkVehicle(entryGate1);
    }
    private void parkVehicle(EntryGate entryGate1){
        entryGate1.removeVehicle();
        parkingSpot.parkVehicle(this);
    }
    public void unParkVehicle(){
        parkingSpot.removeVehicle();
        parkingSpot.parkVehicle(null);
    }

    public void exitParkingLot(ExitGate exitGate){
        Bill bill = exitGate.assignExitVehicle(this);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType=" + vehicleType +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", ticket=" + ticket +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}
