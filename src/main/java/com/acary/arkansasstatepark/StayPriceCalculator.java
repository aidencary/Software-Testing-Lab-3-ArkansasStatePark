package com.acary.arkansasstatepark;

public class StayPriceCalculator {

    // Constants
    public static final int baseNightPrice = 50;
    public static final double childDiscount = 0.5;
    public static final double adultDiscount = 1; // No discount
    public static final double seniorDiscount = 0.8;
    public static final double veteranDiscount = 0.9;
    public static final int arkResidentFlatDiscount = 10;


    public static double calculateStayPrice(int nights, int guestAge, boolean isArkansasResident, boolean hasVeteranDiscount) {
        // 1. Validate Input (nights BVA: 1-14)
        if (nights < 1 || nights > 14 || guestAge < 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        // 2. Calculate Initial Price (nights * Base Price)
        double stayPrice = nights * baseNightPrice;

        // 3. Apply Age-based Discount (EP/BVA)
        if (guestAge >= 0 && guestAge <= 12) {
            stayPrice *= childDiscount; // 50% off
        }
        else if (guestAge >= 13 && guestAge <= 64) {
            stayPrice *= adultDiscount; // Full price
        }
        else if (guestAge >= 65) {
            stayPrice *= seniorDiscount; // 20% off
        }


        // 4. Apply Residency & Veteran Status (Decision Table logic)
        // Rule: If both, subtract $10 first, then apply 10% discount
        if (isArkansasResident) {
            stayPrice -= arkResidentFlatDiscount;
        }

        if (hasVeteranDiscount) {
            stayPrice *= veteranDiscount;
        }

        return stayPrice;
    }
}
