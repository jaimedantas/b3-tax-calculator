package com.jaimedantas.fiitaxcalculator.controller;

import com.jaimedantas.fiitaxcalculator.business.TaxCalculator;
import com.jaimedantas.fiitaxcalculator.model.FiiData;
import com.jaimedantas.fiitaxcalculator.model.FiiTax;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@Controller
@RequestMapping(path="/tax")
@Api("Tax Calculator for Real Estate Funds")
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @ApiOperation("Calculates de total taxes for FII")
    @CrossOrigin(origins = "*")
    @PostMapping(path="/fii", produces = "application/json", consumes = "application/json")
    public @ResponseBody FiiTax calculateFiiTaxes (@RequestBody FiiData fii) throws Throwable {

        //not implement yet
        if (fii.getTotalValueBought().equals(new BigDecimal(0)) && fii.getTotalValueSold().equals(new BigDecimal(0))){
            throw new Throwable("Unit price not implemented yet");
        }

        logger.info(fii.toString());
        TaxCalculator taxCalculator = new TaxCalculator();

        FiiTax result = taxCalculator.calculeFiiTaxes(fii);

        logger.info(result.toString());
        return result;

    }

}
