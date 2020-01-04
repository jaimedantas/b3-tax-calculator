package com.jaimedantas.fiitaxcalculator.business;

import com.jaimedantas.fiitaxcalculator.model.FiiData;
import com.jaimedantas.fiitaxcalculator.model.FiiTax;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test
    void shouldCalculateTaxForFiiXPLG11() {
        FiiData fiiData = new FiiData();
        fiiData.setName("XPLG11");
        fiiData.setPurchasePriceUnit(new BigDecimal("101"));
        fiiData.setQuantityBought(200l);
        fiiData.setQuantitySold(200l);
        fiiData.setSoldPriceUnit(new BigDecimal("130.20"));
        fiiData.setTotalValueBought(new BigDecimal("2121.00"));
        fiiData.setTotalValueSold(new BigDecimal("3013.71"));

        BigDecimal expectedTotalProfitPercentage = new BigDecimal("0.34");
        BigDecimal expectedTotalProfitValue = new BigDecimal("713.55");
        BigDecimal expectedTDarf = new BigDecimal("178.39");


        TaxCalculator taxCalculator = new TaxCalculator();

        FiiTax fiiTax = taxCalculator.calculeFiiTaxes(fiiData);

        assertEquals(expectedTotalProfitPercentage, fiiTax.getTotalProfitPercentage());
        assertEquals(expectedTotalProfitValue, fiiTax.getTotalProfitValue());
        assertEquals(expectedTDarf, fiiTax.getFixedTax());

    }

    @Test
    void shouldCalculateTaxForFiiXPML11() {
        FiiData fiiData = new FiiData();
        fiiData.setName("XPML11");
        fiiData.setPurchasePriceUnit(new BigDecimal("109"));
        fiiData.setQuantityBought(47);
        fiiData.setQuantitySold(47);
        fiiData.setSoldPriceUnit(new BigDecimal("138.99"));
        fiiData.setTotalValueBought(new BigDecimal("5168.59"));
        fiiData.setTotalValueSold(new BigDecimal("6532.53"));

        BigDecimal expectedTotalProfitPercentage = new BigDecimal("0.21");
        BigDecimal expectedTotalProfitValue = new BigDecimal("1089.64");
        BigDecimal expectedTDarf = new BigDecimal("272.41");


        TaxCalculator taxCalculator = new TaxCalculator();

        FiiTax fiiTax = taxCalculator.calculeFiiTaxes(fiiData);

        assertEquals(expectedTotalProfitPercentage, fiiTax.getTotalProfitPercentage());
        assertEquals(expectedTotalProfitValue, fiiTax.getTotalProfitValue());
        assertEquals(expectedTDarf, fiiTax.getFixedTax());

    }


}