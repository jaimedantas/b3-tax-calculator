package com.jaimedantas.fiitaxcalculator.controller;

import com.jaimedantas.fiitaxcalculator.business.TaxCalculator;
import com.jaimedantas.fiitaxcalculator.model.FiiData;
import com.jaimedantas.fiitaxcalculator.model.FiiTax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Objects;


@Controller
@RequestMapping(path="/tax")
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

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
