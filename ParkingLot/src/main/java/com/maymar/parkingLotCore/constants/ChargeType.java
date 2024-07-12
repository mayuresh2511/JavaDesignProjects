package com.maymar.parkingLotCore.constants;

public enum ChargeType {
    MINUTE_BASED(10),
    HOUR_BASED(50),
    DAY_BASED(200);

    private int chargeAmount;

    private ChargeType(int chargeAmount){
        this.chargeAmount = chargeAmount;
    }

    public int getChargeAmount(){
        return chargeAmount;
    }
}
