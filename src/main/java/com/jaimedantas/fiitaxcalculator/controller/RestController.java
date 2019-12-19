package com.jaimedantas.fiitaxcalculator.controller;

import com.jaimedantas.fiitaxcalculator.business.TaxCalculator;
import com.jaimedantas.fiitaxcalculator.model.FiiData;
import com.jaimedantas.fiitaxcalculator.model.FiiTax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping(path="/tax")
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @CrossOrigin(origins = "*")
    @PostMapping(path="/fii")
    public @ResponseBody FiiTax calculateFiiTaxes (@RequestBody FiiData fii) {
        logger.info(fii.toString());
        TaxCalculator taxCalculator = new TaxCalculator();

        FiiTax result = taxCalculator.calculeFiiTaxes(fii);

        logger.info(result.toString());
        return result;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/test")
    public @ResponseBody String test () {
        return "test";
    }

}
