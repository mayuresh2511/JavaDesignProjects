package com.maymar.parkingLotCore.chargeCalculator;

import com.maymar.parkingLotCore.constants.VehicleType;

public interface ChargeCalculator {
    int calculateCharges(int charges, VehicleType vehicleType, String entryTime);
}
