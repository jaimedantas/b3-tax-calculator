package com.jaimedantas.fiitaxcalculator.enums;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public enum B3Taxes {
    IRRF("IRRF", 1, new BigDecimal(String.valueOf(0.000050))),
    EMOLUMENTOS("EMOLUMENTOS", 2, new BigDecimal(String.valueOf(0.000040))),
    FIX_TAX("TAXA", 2, new BigDecimal(String.valueOf(0.20))),
    LIQUIDACAO("LIQUIDACAO", 10, new BigDecimal(String.valueOf(0.000275)));

    private static final Map<String, B3Taxes> BY_LABEL = new HashMap<>();
    private static final Map<Integer, B3Taxes> BY_ATOMIC_NUMBER = new HashMap<>();
    private static final Map<BigDecimal, B3Taxes> BY_ATOMIC_VALUE = new HashMap<>();

    static {
        for (B3Taxes e : values()) {
            BY_LABEL.put(e.label, e);
            BY_ATOMIC_NUMBER.put(e.atomicNumber, e);
            BY_ATOMIC_VALUE.put(e.atomicValue, e);
        }
    }

    public final String label;
    public final int atomicNumber;
    public final BigDecimal atomicValue;

    private B3Taxes(String label, int atomicNumber, BigDecimal atomicValue) {
        this.label = label;
        this.atomicNumber = atomicNumber;
        this.atomicValue = atomicValue;
    }

    public static B3Taxes valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static B3Taxes valueOfAtomicNumber(int number) {
        return BY_ATOMIC_NUMBER.get(number);
    }

    public static B3Taxes valueOfAtomicWeight(BigDecimal value) {
        return BY_ATOMIC_VALUE.get(value);
    }
}