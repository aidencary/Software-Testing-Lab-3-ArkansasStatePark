package com.acary.arkansasstatepark;

public class StayPriceCalculator {

    // Constants
    private static final int MIN_STAY = 1;
    private static final int MAX_STAY = 14;

    private static final int BASE_NIGHT_PRICE = 50;

    private static final double CHILD_DISCOUNT = 0.5;
    private static final double ADULT_DISCOUNT = 1.0; // No discount
    private static final double SENIOR_DISCOUNT = 0.8;
    private static final double VETERAN_DISCOUNT = 0.9;

    private static final int ARK_RESIDENT_FLAT_DISCOUNT = 10;



    public static double calculateStayPrice(int nights, int guestAge, boolean isArkansasResident, boolean hasVeteranDiscount) {
        // 1. Validate Input (nights BVA: 1-14)
        if (nights < MIN_STAY || nights > MAX_STAY || guestAge < 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        // 2. Calculate Initial Price (nights * Base Price)
        double stayPrice = nights * BASE_NIGHT_PRICE;

        // 3. Apply Age-based Discount (EP/BVA)
        if (guestAge >= 0 && guestAge <= 12) {
            stayPrice *= CHILD_DISCOUNT; // 50% off
        }
        else if (guestAge >= 13 && guestAge <= 64) {
            stayPrice *= ADULT_DISCOUNT; // Full price
        }
        else if (guestAge >= 65) {
            stayPrice *= SENIOR_DISCOUNT; // 20% off
        }


        // 4. Apply Residency & Veteran Status (Decision Table logic)
        // Rule: If both, subtract $10 first, then apply 10% discount
        if (isArkansasResident) {
            stayPrice -= ARK_RESIDENT_FLAT_DISCOUNT;
        }

        if (hasVeteranDiscount) {
            stayPrice *= VETERAN_DISCOUNT;
        }

        return stayPrice;
    }
}
