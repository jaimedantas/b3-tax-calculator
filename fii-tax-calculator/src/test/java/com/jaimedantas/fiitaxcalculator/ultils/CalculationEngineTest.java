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
    void shouldAddThreeBigDecimals() {
        BigDecimal num1 = new BigDecimal("10.00");
        BigDecimal num2 = new BigDecimal("20.00");
        BigDecimal num3 = new BigDecimal("21943.00");
        BigDecimal expected = new BigDecimal("21973.00");

        BigDecimal result = CalculationEngine.add(num1, num2, num3);

        assertEquals(expected, result);
    }

    @Test
    void shouldAddFourBigDecimals() {
        BigDecimal num1 = new BigDecimal("10.00");
        BigDecimal num2 = new BigDecimal("20.00");
        BigDecimal num3 = new BigDecimal("2199.00");
        BigDecimal num4 = new BigDecimal("329.00");
        BigDecimal expected = new BigDecimal("2558.00");

        BigDecimal result = CalculationEngine.add(num1, num2, num3, num4);

        assertEquals(expected, result);
    }

    @Test
    void shouldAddFiveBigDecimals() {
        BigDecimal num1 = new BigDecimal("10.00");
        BigDecimal num2 = new BigDecimal("20.00");
        BigDecimal num3 = new BigDecimal("2199.00");
        BigDecimal num4 = new BigDecimal("329.00");
        BigDecimal num5 = new BigDecimal("323400");
        BigDecimal expected = new BigDecimal("326287.00");

        BigDecimal result = CalculationEngine.add(num1, num2, num3, num4, num5);

        assertEquals(expected, result);
    }

    @Test
    void shouldSubtractTwoBigDecimals() {
        BigDecimal num1 = new BigDecimal("10.00");
        BigDecimal num2 = new BigDecimal("20.00");
        BigDecimal expected = new BigDecimal("-10.00");

        BigDecimal result = CalculationEngine.subtract(num1, num2);

        assertEquals(expected, result);
    }

    @Test
    void shouldSubtractThreeBigDecimals() {
        BigDecimal num1 = new BigDecimal("450.00");
        BigDecimal num2 = new BigDecimal("20.00");
        BigDecimal num3 = new BigDecimal("10.00");
        BigDecimal expected = new BigDecimal("420.00");

        BigDecimal result = CalculationEngine.subtract(num1, num2, num3);

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