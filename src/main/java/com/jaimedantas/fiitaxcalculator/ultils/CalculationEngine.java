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

    public static BigDecimal add(BigDecimal arg1, BigDecimal arg2, BigDecimal arg3){
        return add(arg1.add(arg2), arg3);
    }

    public static BigDecimal add(BigDecimal arg1, BigDecimal arg2, BigDecimal arg3, BigDecimal arg4){
        return add(add(arg1, arg2, arg3), arg4);
    }

    public static BigDecimal subtract(BigDecimal arg1, BigDecimal arg2){
        return arg1.subtract(arg2).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal subtract(BigDecimal arg1, BigDecimal arg2, BigDecimal arg3){
        return subtract(arg1.subtract(arg2), arg3);
    }

    public static BigDecimal divide(BigDecimal arg1, BigDecimal arg2){
        return arg1.divide(arg2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiply(BigDecimal arg1, BigDecimal arg2){
        return arg1.multiply(arg2).setScale(2, RoundingMode.HALF_UP);
    }

}
