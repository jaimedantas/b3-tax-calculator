package com.jaimedantas.fiitaxcalculator.ultils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationEngine {

    private CalculationEngine() {
        throw new IllegalStateException("Static class");
    }

    public static BigDecimal add(BigDecimal arg1, BigDecimal arg2){
        return arg1.add(arg2).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiply(BigDecimal arg1, BigDecimal arg2){
        return arg1.multiply(arg2).setScale(2, RoundingMode.HALF_UP);
    }

}
