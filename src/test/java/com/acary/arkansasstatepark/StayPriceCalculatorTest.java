package com.acary.arkansasstatepark;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StayPriceCalculatorTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test_cases.csv", numLinesToSkip = 1)
    public void testCalculateStayPrice(String testCase, int nights, int guestAge, boolean isArkansasResident,
                                boolean hasVeteranDiscount, double expectedResult, boolean isError) {

        if (isError) {
            // Verifies that invalid inputs (like 0 nights) throw an Exception
            assertThrows(IllegalArgumentException.class, () -> {
                StayPriceCalculator.calculateStayPrice(nights, guestAge, isArkansasResident, hasVeteranDiscount);
            }, String.format("Test Case %s Failed -- Expected an IllegalArgumentException but none was thrown.", testCase));
        } else {
            // Verifies the calc for valid inputs (including all the discounts and boundaries)
            double actualResult = StayPriceCalculator.calculateStayPrice(nights, guestAge, isArkansasResident, hasVeteranDiscount);
            assertEquals(expectedResult, actualResult, 0.01,
                    String.format(
                            "Test Case %s Failed -- Nights: %d, Age: %d, AR Resident: %b, Veteran: %b | Expected: %.2f, Actual: %.2f",
                            testCase, nights, guestAge, isArkansasResident, hasVeteranDiscount, expectedResult, actualResult
                    ));
        }
    }
}
