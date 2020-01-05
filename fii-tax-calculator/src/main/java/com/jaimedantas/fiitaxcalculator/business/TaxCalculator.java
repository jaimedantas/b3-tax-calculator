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

        BigDecimal emolumentosTaxesBuy = CalculationEngine.multiply(fiiData.getTotalValueBought(),B3Taxes.EMOLUMENTOS.atomicValue);
        BigDecimal liquidacaoTaxesBuy = CalculationEngine.multiply(fiiData.getTotalValueBought(),B3Taxes.LIQUIDACAO.atomicValue);
        BigDecimal emolumentosTaxesSell = CalculationEngine.multiply(fiiData.getTotalValueSold(),B3Taxes.EMOLUMENTOS.atomicValue);
        BigDecimal liquidacaoTaxesSell = CalculationEngine.multiply(fiiData.getTotalValueSold(),B3Taxes.LIQUIDACAO.atomicValue);
        BigDecimal IRRFTaxes = CalculationEngine.multiply(fiiData.getTotalValueSold(),B3Taxes.IRRF.atomicValue);

        BigDecimal totalTaxes = CalculationEngine.add(emolumentosTaxesBuy,liquidacaoTaxesBuy, IRRFTaxes,
                emolumentosTaxesSell, liquidacaoTaxesSell);
        BigDecimal realProfitAfterTaxes = CalculationEngine.subtract(netProfitValue, totalTaxes);
        BigDecimal fixTax = CalculationEngine.multiply(realProfitAfterTaxes,B3Taxes.FIX_TAX.atomicValue);

        result.setEmolumentosFee(CalculationEngine.add(emolumentosTaxesBuy,emolumentosTaxesSell));
        result.setLiquidacaoFee(CalculationEngine.add(emolumentosTaxesBuy,liquidacaoTaxesSell));
        result.setIRRFFee(IRRFTaxes);
        result.setFixedTax(fixTax);

        BigDecimal totalProfit = CalculationEngine.subtract(netProfitValue, totalTaxes, fixTax);
        BigDecimal totalProfitPercentage = CalculationEngine.divide(totalProfit, CalculationEngine.add(fiiData.getTotalValueBought(),
                liquidacaoTaxesBuy, emolumentosTaxesBuy));

        result.setTotalTaxes(totalTaxes);
        result.setTotalProfitValue(totalProfit);
        result.setTotalProfitPercentage(totalProfitPercentage);

        return result;
    }
}
