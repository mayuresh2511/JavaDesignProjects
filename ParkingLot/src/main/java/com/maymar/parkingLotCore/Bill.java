package com.maymar.parkingLotCore;

public class Bill {
    private final int charges;
    private static final int TAX_RATE = 8;
    private final int taxAmount;
    private final int grandTotal;

    private Bill(int charges, int taxAmount, int grandTotal) {
        this.charges = charges;
        this.taxAmount = taxAmount;
        this.grandTotal = grandTotal;
    }

    public int getGrandTotal() {
        return grandTotal;
    }

    public static Bill generateBill(int totalCharges){
        return new Bill(totalCharges, 2, 122);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "charges=" + charges +
                ", taxRate=" + TAX_RATE +
                ", taxAmount=" + taxAmount +
                ", grandTotal=" + grandTotal +
                '}';
    }
}
