package com.maymar.parkingLotCore.chargeCalculator;

import com.maymar.parkingLotCore.constants.VehicleType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MinuteBasedChargeCalculator implements ChargeCalculator{
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
            long diffInMinutes = (diffInMillis / (60 * 1000)) % 60;
            System.out.println("In diff minutes : " + diffInMinutes);
            finalCharges = (int) (charges * (diffInMinutes == 0 ? 1 : diffInMinutes));
            System.out.println("Final minute based charges : " + finalCharges);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return finalCharges;
    }
}
