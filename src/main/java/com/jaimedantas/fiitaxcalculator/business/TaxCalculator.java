package com.jaimedantas.fiitaxcalculator.business;

import com.jaimedantas.fiitaxcalculator.enums.B3Taxes;
import com.jaimedantas.fiitaxcalculator.model.FiiData;
import com.jaimedantas.fiitaxcalculator.model.FiiTax;
import com.jaimedantas.fiitaxcalculator.ultils.CalculationEngine;

import java.math.BigDecimal;

public class TaxCalculator {

    public FiiTax calculeFiiTaxes(FiiData fiiData){
        FiiTax result = new FiiTax();
        result.setEmolumentosFee(new BigDecimal(String.valueOf(B3Taxes.EMOLUMENTOS.atomicValue)));
        result.setLiquidacaoFee(new BigDecimal(String.valueOf(B3Taxes.LIQUIDACAO.atomicValue)));
        result.setIRRFFee(new BigDecimal(String.valueOf(B3Taxes.IRRF.atomicValue)));
        result.setFixTax(new BigDecimal(String.valueOf(B3Taxes.FIX_TAX.atomicValue)));

        BigDecimal netProfitValue = CalculationEngine.subtract(fiiData.getTotalValueSold(), fiiData.getTotalValueBought());
        BigDecimal emolumentosTaxes = CalculationEngine.multiply(fiiData.getTotalValueBought(),B3Taxes.EMOLUMENTOS.atomicValue);
        BigDecimal liquidacaoTaxes = CalculationEngine.multiply(fiiData.getTotalValueBought(),B3Taxes.LIQUIDACAO.atomicValue);
        BigDecimal IRRFTaxes = CalculationEngine.multiply(fiiData.getTotalValueBought(),B3Taxes.IRRF.atomicValue);
        BigDecimal fixTax = CalculationEngine.multiply(netProfitValue,B3Taxes.FIX_TAX.atomicValue);
        BigDecimal totalTaxes = CalculationEngine.add(emolumentosTaxes,liquidacaoTaxes, IRRFTaxes, fixTax);
        BigDecimal totalProfit = CalculationEngine.subtract(netProfitValue, totalTaxes);
        BigDecimal totalProfitPercentage = CalculationEngine.divide(totalProfit, fiiData.getTotalValueBought());

        result.setTotalTaxes(totalTaxes);
        result.setTotalProfitValue(totalProfit);
        result.setTotalProfitPercentage(totalProfitPercentage);

        return result;
    }
}
