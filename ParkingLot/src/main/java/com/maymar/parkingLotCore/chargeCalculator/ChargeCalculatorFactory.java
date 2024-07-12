package com.maymar.parkingLotCore.chargeCalculator;

import com.maymar.parkingLotCore.constants.ChargeType;

public class ChargeCalculatorFactory {

    public static ChargeCalculator getChargeCalculator(ChargeType chargeType){
        ChargeCalculator chargeCalculator;

        if (chargeType.equals(ChargeType.MINUTE_BASED)){
            chargeCalculator = new MinuteBasedChargeCalculator();
        }else if (chargeType.equals(ChargeType.HOUR_BASED)){
            chargeCalculator = new HourBasedChargeCalculator();
        }else {
            chargeCalculator = new MinuteBasedChargeCalculator();
        }

        return chargeCalculator;
    }
}
