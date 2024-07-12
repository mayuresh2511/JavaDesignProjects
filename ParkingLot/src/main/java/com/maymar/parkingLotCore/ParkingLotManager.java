package com.maymar.parkingLotCore;

import com.maymar.parkingLotCore.constants.ParkingSpotType;
import com.maymar.parkingLotCore.constants.VehicleType;
import com.maymar.parkingLotCore.impls.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private List<ParkingSpot> fourWheelerParkingSpots;
    private List<ParkingSpot> twoWheelerParkingSpots;
    private static DashBoard dashBoard;
    private static ParkingLotManager parkingLotManager;
    private int totalParkingSpots;
    private ParkingLotManager(){
        init();
    }

    public static ParkingLotManager getParkingLotManager(DashBoard newDashBoard){
        dashBoard = newDashBoard;
        if (parkingLotManager == null){
            parkingLotManager = new ParkingLotManager();
        }
        return parkingLotManager;
    }

    private void init() {
        fourWheelerParkingSpots = new ArrayList<ParkingSpot>();
        twoWheelerParkingSpots = new ArrayList<ParkingSpot>();
        for (int i = 1; i <= 20; i++){
            fourWheelerParkingSpots.add(new ParkingSpot(false,
                    ParkingSpotType.FOUR_WHEELER,
                    100+i));
        }
        for (int i = 1; i <= 20; i++){
            twoWheelerParkingSpots.add(new ParkingSpot(false,
                    ParkingSpotType.TWO_WHEELER,
                    200+i));
        }
        this.totalParkingSpots = fourWheelerParkingSpots.size() + twoWheelerParkingSpots.size();
        dashBoard.update(this);
    }

    public ParkingSpot getParkingSpot(VehicleType vehicleType) {
        ParkingSpot parkingSpot = null;
        if (vehicleType.equals(VehicleType.FOUR_WHEELER)){
            if (!fourWheelerParkingSpots.isEmpty()){
                parkingSpot = fourWheelerParkingSpots.remove(0);
            }
        } else if (vehicleType.equals(VehicleType.TWO_WHEELER)) {
            if (!twoWheelerParkingSpots.isEmpty()){
                parkingSpot = twoWheelerParkingSpots.remove(0);
            }
        }

        dashBoard.update(this);
        return parkingSpot;
    }

    public void returnParkingSpot(ParkingSpot parkingSpot){
        if (parkingSpot.getType().equals(ParkingSpotType.FOUR_WHEELER)){
            fourWheelerParkingSpots.add(parkingSpot);
        }else {
            twoWheelerParkingSpots.add(parkingSpot);
        }
        dashBoard.update(this);
    }
    public int getTotalParkingSpots(){
        return totalParkingSpots;
    }
    public int getFourWheelerParkingSpots(){
        return fourWheelerParkingSpots.size();
    }
    public int getTwoWheelerParkingSpots(){
        return twoWheelerParkingSpots.size();
    }
    @Override
    public String toString() {
        return "ParkingLotManager{" +
                "fourWheelerParkingSpots=" + fourWheelerParkingSpots +
                ", twoWheelerParkingSpots=" + twoWheelerParkingSpots +
                '}';
    }
}
