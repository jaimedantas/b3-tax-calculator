package com.jaimedantas.fiitaxcalculator.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaimedantas.fiitaxcalculator.model.FiiData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestController.class)
public class RestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shoudCallApiAndReturnSucess() throws Exception {

        FiiData imput = new FiiData();
        imput.setTotalValueSold(new BigDecimal("9029"));
        imput.setTotalValueBought(new BigDecimal("1029"));

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(imput);

        this.mvc.perform(post("/tax/fii")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().is2xxSuccessful());
    }




}