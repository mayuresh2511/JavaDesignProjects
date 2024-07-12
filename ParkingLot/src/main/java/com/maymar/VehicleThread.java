package com.maymar;

import com.maymar.entitty.Vehicle;
import com.maymar.parkingLotCore.EntryGate;
import com.maymar.parkingLotCore.ExitGate;
import com.maymar.parkingLotCore.constants.VehicleType;

public class VehicleThread implements Runnable{
    private EntryGate entryGate;
    private ExitGate exitGate;
    private int sleepSeconds;
    private VehicleType vehicleType;
    private String vehicleNumber;

    public VehicleThread(EntryGate entryGate,
                         ExitGate exitGate,
                         int sleepSeconds,
                         VehicleType vehicleType,
                         String vehicleNumber) {
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.sleepSeconds = sleepSeconds;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public void run() {
        Vehicle vehicle = new Vehicle(vehicleType, vehicleNumber);

//        System.out.println("Vehicle initialized => " + vehicle.toString());

        vehicle.enterInParkingLot(entryGate);

//        System.out.println("Vehicle parked => " + vehicle.toString());
//        System.out.println("Parking DashBoard => " + dashBoard.toString());

        try {
            Thread.sleep(sleepSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        vehicle.unParkVehicle();
        vehicle.exitParkingLot(exitGate);

//        System.out.println("Vehicle parked => " + vehicle.toString());
//        System.out.println("Parking DashBoard => " + dashBoard.toString());
    }
}
