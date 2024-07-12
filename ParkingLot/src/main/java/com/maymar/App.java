package com.maymar;

import com.maymar.parkingLotCore.DashBoard;
import com.maymar.parkingLotCore.EntryGate;
import com.maymar.parkingLotCore.ExitGate;
import com.maymar.parkingLotCore.ParkingLotManager;
import com.maymar.parkingLotCore.constants.VehicleType;

public class App 
{
    public static void main( String[] args )
    {
        DashBoard dashBoard = new DashBoard();
        ParkingLotManager parkingLotManager = ParkingLotManager.getParkingLotManager(dashBoard);
        EntryGate entryGate = new EntryGate(parkingLotManager);
        ExitGate exitGate = new ExitGate(parkingLotManager);

        VehicleThread v1 = new VehicleThread(entryGate,
                exitGate,
                120000,
                VehicleType.FOUR_WHEELER,
                "MH04AS7654");
        VehicleThread v2 = new VehicleThread(entryGate,
                exitGate,
                180000,
                VehicleType.TWO_WHEELER,
                "MH26AZ7654");

        Thread thread1 = new Thread(v1);
        Thread thread2 = new Thread(v2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Program Ended.....");
    }
}
