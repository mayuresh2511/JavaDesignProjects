package com.maymar.parkingLotCore;

import com.maymar.entitty.Vehicle;
import com.maymar.parkingLotCore.chargeCalculator.ChargeCalculator;
import com.maymar.parkingLotCore.chargeCalculator.ChargeCalculatorFactory;
import com.maymar.payments.PaymentInterface;

public class ExitGate {

    private Vehicle vehicle;
    private final ParkingLotManager parkingLotManager;
    private Bill currentBill;

    public ExitGate(ParkingLotManager parkingLotManager){
        this.parkingLotManager = parkingLotManager;
    }

    public synchronized Bill assignExitVehicle(Vehicle exitVehicle){
        System.out.println("Inside exit gate.. " + Thread.currentThread().getName());
        vehicle = exitVehicle;
        System.out.println(Thread.currentThread().getName() + " => Vehicle " + vehicle.getVehicleNumber() + " exiting parkingLot gate");
        parkingLotManager.returnParkingSpot(vehicle.getParkingSpot());
        vehicle.setParkingSpot(null);
        return calculateTotalCharges();
    }
    private Bill calculateTotalCharges(){
        ChargeCalculator chargeCalculator = ChargeCalculatorFactory.getChargeCalculator(
                vehicle.getTicket().getChargeType()
        );
        int finalCharge = chargeCalculator.calculateCharges(vehicle.getTicket().getCharge(),
                vehicle.getVehicleType(),
                vehicle.getTicket().getGenerationTime());
        vehicle.setParkingTicket(null);
        currentBill = Bill.generateBill(finalCharge);
        return  currentBill;
    }
    public void pay(PaymentInterface paymentInterface){
        System.out.println("Inside pay method of ExitGate");
        paymentInterface.pay(currentBill.getGrandTotal());
        currentBill = null;
    }
}
