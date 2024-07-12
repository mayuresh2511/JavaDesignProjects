package com.maymar.parkingLotCore;

public class DashBoard {
    private int totalParkingSpots;
    private int fourWheelerParkingSpots;
    private int twoWheelerParkingSpots;
    private boolean isParkingLotFull;
    private int availableParkingSpots;

    public void update(ParkingLotManager parkingLotManager) {
        this.totalParkingSpots = parkingLotManager.getTotalParkingSpots();
        this.fourWheelerParkingSpots = parkingLotManager.getFourWheelerParkingSpots();
        this.twoWheelerParkingSpots = parkingLotManager.getTwoWheelerParkingSpots();
        this.availableParkingSpots = fourWheelerParkingSpots + twoWheelerParkingSpots;
        if (availableParkingSpots != 0){
            this.isParkingLotFull = false;
        }else{
            this.isParkingLotFull = true;
        }
        printDashboard();
    }

    private void printDashboard() {
        System.out.println("DashBoard : \n" +
                "Total Parking Spots : " + totalParkingSpots + "\n" +
                "Four Wheeler Parking Spots : " + fourWheelerParkingSpots + "\n" +
                "Two Wheeler Parking Spots : " + twoWheelerParkingSpots + "\n" +
                "Parking Lot Full : " + isParkingLotFull + "\n" +
                "Available Parking Spots : " + availableParkingSpots);
    }
}
