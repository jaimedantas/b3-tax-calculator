package com.jaimedantas.fiitaxcalculator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiiTax {
    BigDecimal totalTaxes;
    int totalProfitPercentage;
    BigDecimal totalProfitValue;
}
