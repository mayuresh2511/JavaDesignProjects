package com.maymar.parkingLotCore.interfaces;

import com.maymar.entitty.Vehicle;
import com.maymar.parkingLotCore.constants.ParkingSpotType;

public interface ParkingSpotInterface {

    void parkVehicle(Vehicle vehicle);
    void removeVehicle();
    boolean isOccupied();
    ParkingSpotType getType();
    int getParkingSpotNumber();
}
