package com.jaimedantas.fiitaxcalculator.business;

import com.jaimedantas.fiitaxcalculator.model.FiiData;
import com.jaimedantas.fiitaxcalculator.model.FiiTax;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test
    void shouldCalculateTaxForFii() {
        FiiData fiiData = new FiiData();
        fiiData.setName("XPLG11");
        fiiData.setPurchasePriceUnit(new BigDecimal("101"));
        fiiData.setPurchaseTransactionFees(new BigDecimal("1.4"));
        fiiData.setQuantityBought(200l);
        fiiData.setQuantitySold(200l);
        fiiData.setSoldPrice(new BigDecimal("130.20"));
        fiiData.setSoldTransactionFees(new BigDecimal("14.9"));
        fiiData.setTotalValueBought(new BigDecimal("2121.00"));
        fiiData.setTotalValueSold(new BigDecimal("3013.71"));

        BigDecimal expectedTotalProfitPercentage = new BigDecimal("0.34");
        BigDecimal expectedTotalProfitValue = new BigDecimal("713.55");
        BigDecimal expectedTDarf = new BigDecimal("178.39");


        TaxCalculator taxCalculator = new TaxCalculator();

        FiiTax fiiTax = taxCalculator.calculeFiiTaxes(fiiData);

        assertEquals(fiiTax.getTotalProfitPercentage(), expectedTotalProfitPercentage);
        assertEquals(fiiTax.getTotalProfitValue(), expectedTotalProfitValue);
        assertEquals(fiiTax.getFixTax(), expectedTDarf);

    }


}