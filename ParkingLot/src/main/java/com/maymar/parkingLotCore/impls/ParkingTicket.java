package com.maymar.parkingLotCore.impls;

import com.maymar.parkingLotCore.constants.ChargeType;
import com.maymar.parkingLotCore.interfaces.ParkingTicketInterface;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket implements ParkingTicketInterface {

    private final UUID ticketId;
    private final int charge;
    private final String vehicleNumber;
    private final int parkingSpotNumber;
    private final ChargeType chargeType;
    private final String generationTimeStamp;

    public ParkingTicket(UUID ticketId,
                         int charge,
                         String vehicleNumber,
                         int parkingSpotNumber,
                         ChargeType chargeType,
                         String generationTimeStamp) {
        this.ticketId = ticketId;
        this.charge = charge;
        this.vehicleNumber = vehicleNumber;
        this.parkingSpotNumber = parkingSpotNumber;
        this.chargeType = chargeType;
        this.generationTimeStamp = generationTimeStamp;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getCharge() {
        return charge;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }

    public String getGenerationTime() {
        return generationTimeStamp;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "ticketId=" + ticketId +
                ", charge=" + charge +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", parkingSpotNumber=" + parkingSpotNumber +
                ", chargeType=" + chargeType +
                ", generationTimeStamp='" + generationTimeStamp + '\'' +
                '}';
    }
}
