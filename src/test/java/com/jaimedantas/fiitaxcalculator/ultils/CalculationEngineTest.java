package com.jaimedantas.fiitaxcalculator.ultils;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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

    @Test
    void shouldDivideTwoBigDecimals() {
        BigDecimal num1 = new BigDecimal("10.00");
        BigDecimal num2 = new BigDecimal("20.00");
        BigDecimal expected = new BigDecimal("0.50");

        BigDecimal result = CalculationEngine.divide(num1, num2);

        assertEquals(expected, result);
    }

    @Test
    void shouldDivideBigdecimalWithATooBigBigdecimal() {
        BigDecimal num1 = new BigDecimal("10.00");
        BigDecimal num2 = new BigDecimal("200980889.00");
        BigDecimal expected = new BigDecimal("0.00");

        BigDecimal result = CalculationEngine.divide(num1, num2);

        assertEquals(expected, result);
    }



}