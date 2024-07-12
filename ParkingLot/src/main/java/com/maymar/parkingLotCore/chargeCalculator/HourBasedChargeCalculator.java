package com.maymar.parkingLotCore.chargeCalculator;

import com.maymar.parkingLotCore.constants.VehicleType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HourBasedChargeCalculator implements ChargeCalculator{
    @Override
    public int calculateCharges(int charges, VehicleType vehicleType, String entryTime) {
        int finalCharges = 0;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
            String exitTime = sdf.format(date);

            Date entryDateTime = sdf.parse(entryTime);
            Date exitDateTime = sdf.parse(exitTime);
            long diffInMillis = exitDateTime.getTime() - entryDateTime.getTime();
            System.out.println("In diff milli second : " + diffInMillis);
            long diffInHours = (diffInMillis / (60 * 60 * 1000)) % 24;
            System.out.println("In diff hours : " + diffInHours);
            finalCharges = (int) (charges * (diffInHours == 0 ? 1 : diffInHours));
            System.out.println("Final hour based charges : " + finalCharges);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return finalCharges;
    }
}
