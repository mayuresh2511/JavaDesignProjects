package com.maymar.parkingLotCore.interfaces;

import com.maymar.parkingLotCore.constants.ChargeType;

import java.util.Date;
import java.util.UUID;

public interface ParkingTicketInterface {

    UUID getTicketId();
    String getVehicleNumber();
    int getCharge();
    int getParkingSpotNumber();
    ChargeType getChargeType();
    String getGenerationTime();
}
