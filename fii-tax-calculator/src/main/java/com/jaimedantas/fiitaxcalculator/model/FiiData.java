package com.jaimedantas.fiitaxcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiiData {

    String name;

    long quantityBought;
    long quantitySold;

    BigDecimal purchasePriceUnit;
    BigDecimal soldPriceUnit;

    BigDecimal totalValueBought;
    BigDecimal totalValueSold;

}
