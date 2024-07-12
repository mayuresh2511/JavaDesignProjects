package com.maymar.parkingLotCore;

import com.maymar.entitty.Vehicle;
import com.maymar.parkingLotCore.constants.ChargeType;
import com.maymar.parkingLotCore.impls.ParkingSpot;
import com.maymar.parkingLotCore.impls.ParkingTicket;
import com.maymar.parkingLotCore.interfaces.ParkingTicketInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class EntryGate {
    private Vehicle vehicle;
    private final ParkingLotManager parkingLotManager;

    public EntryGate(ParkingLotManager parkingLotManager) {
        this.parkingLotManager = parkingLotManager;
    }

    public synchronized ParkingSpot assignEntryVehicle(Vehicle entryVehicle){
        System.out.println("Inside entry gate.. " + Thread.currentThread().getName());
        this.vehicle = entryVehicle;
        System.out.println(Thread.currentThread().getName() + " => Vehicle " + vehicle.getVehicleNumber() + " entered parkingLot gate");
        return getParkingSpot();
    }
    public synchronized void removeVehicle(){
        this.vehicle = null;
    }
    private ParkingSpot getParkingSpot(){
        ParkingSpot parkingSpot = parkingLotManager.getParkingSpot(vehicle.getVehicleType());
        System.out.println(Thread.currentThread().getName() + " => Parking spot " + parkingSpot);
        generateTicket(parkingSpot.getParkingSpotNumber());
        return parkingSpot;
    }
    private void generateTicket(int parkingSpotNumber){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdf.format(date);
        ParkingTicketInterface ticket = new ParkingTicket(
                UUID.randomUUID(),
                ChargeType.MINUTE_BASED.getChargeAmount(),
                vehicle.getVehicleNumber(),
                parkingSpotNumber,
                ChargeType.MINUTE_BASED,
                formattedDate
        );
        System.out.println(Thread.currentThread().getName() + " => Ticket : " + ticket);
        vehicle.setParkingTicket(ticket);
    }
}
