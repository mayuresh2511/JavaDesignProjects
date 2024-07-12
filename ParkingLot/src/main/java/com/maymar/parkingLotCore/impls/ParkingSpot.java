package com.maymar.parkingLotCore.impls;

import com.maymar.entitty.Vehicle;
import com.maymar.parkingLotCore.constants.ParkingSpotType;
import com.maymar.parkingLotCore.interfaces.ParkingSpotInterface;

public class ParkingSpot implements ParkingSpotInterface {

    private Vehicle vehicle;
    private boolean isOccupied;
    private final ParkingSpotType parkingSpotType;
    private final int parkingNumber;

    public ParkingSpot(boolean isOccupied,
                       ParkingSpotType parkingSpotType,
                       int parkingNumber){
        this.isOccupied = isOccupied;
        this.parkingSpotType = parkingSpotType;
        this.parkingNumber = parkingNumber;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }
    public void removeVehicle() {
        this.vehicle = null;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
    public ParkingSpotType getType() {
        return parkingSpotType;
    }
    public int getParkingSpotNumber() {
        return parkingNumber;
    }
    @Override
    public String toString() {
        return "ParkingSpot{" +
                "vehicle=" + "{vehicleType: " + (vehicle == null ? "null" : vehicle.getVehicleType()) + " vehicleNumber: " + (vehicle == null ? "null" : vehicle.getVehicleNumber()) +"}" +
                ", isOccupied=" + isOccupied +
                ", parkingSpotType=" + parkingSpotType +
                ", parkingNumber=" + parkingNumber +
                '}';
    }
}
