package com.jaimedantas.fiitaxcalculator.business;

import com.jaimedantas.fiitaxcalculator.enums.B3Taxes;
import com.jaimedantas.fiitaxcalculator.model.FiiData;
import com.jaimedantas.fiitaxcalculator.model.FiiTax;
import com.jaimedantas.fiitaxcalculator.ultils.CalculationEngine;

import java.math.BigDecimal;

public class TaxCalculator {

    public FiiTax calculeFiiTaxes(FiiData fiiData){
        FiiTax result = new FiiTax();

        BigDecimal netProfitValue = CalculationEngine.subtract(fiiData.getTotalValueSold(), fiiData.getTotalValueBought());
        BigDecimal emolumentosTaxes = CalculationEngine.multiply(fiiData.getTotalValueBought(),B3Taxes.EMOLUMENTOS.atomicValue);
        BigDecimal liquidacaoTaxes = CalculationEngine.multiply(fiiData.getTotalValueBought(),B3Taxes.LIQUIDACAO.atomicValue);
        BigDecimal IRRFTaxes = CalculationEngine.multiply(fiiData.getTotalValueBought(),B3Taxes.IRRF.atomicValue);
        BigDecimal totalTaxes = CalculationEngine.add(emolumentosTaxes,liquidacaoTaxes, IRRFTaxes);
        BigDecimal realProfitAfterTaxes = CalculationEngine.subtract(netProfitValue, totalTaxes);
        BigDecimal fixTax = CalculationEngine.multiply(realProfitAfterTaxes,B3Taxes.FIX_TAX.atomicValue);

        result.setEmolumentosFee(emolumentosTaxes);
        result.setLiquidacaoFee(liquidacaoTaxes);
        result.setIRRFFee(IRRFTaxes);
        result.setFixTax(fixTax);

        BigDecimal totalProfit = CalculationEngine.subtract(netProfitValue, totalTaxes, fixTax);
        BigDecimal totalProfitPercentage = CalculationEngine.divide(totalProfit, fiiData.getTotalValueBought());

        result.setTotalTaxes(totalTaxes);
        result.setTotalProfitValue(totalProfit);
        result.setTotalProfitPercentage(totalProfitPercentage);

        return result;
    }
}
