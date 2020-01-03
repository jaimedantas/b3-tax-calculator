package com.jaimedantas.fiitaxcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiiTax {

    BigDecimal totalTaxes;
    BigDecimal totalProfitPercentage;
    BigDecimal totalProfitValue;
    BigDecimal liquidacaoFee;
    BigDecimal emolumentosFee;
    BigDecimal IRRFFee;
    BigDecimal fixedTax;

}
