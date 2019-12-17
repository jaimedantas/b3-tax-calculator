package com.jaimedantas.fiitaxcalculator.ultils;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class CalculationEngineTest {


    @Test
    void shouldAddTwoBigDecimals() {
        BigDecimal num1 = new BigDecimal("10.29");
        BigDecimal num2 = new BigDecimal("9.71");
        BigDecimal expected = new BigDecimal("20.00");

        BigDecimal result = CalculationEngine.add(num1, num2);

        assertEquals(expected, result);
    }


}