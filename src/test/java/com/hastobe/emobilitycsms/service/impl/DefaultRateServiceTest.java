package com.hastobe.emobilitycsms.service.impl;

import com.hastobe.emobilitycsms.dto.RateDto;
import com.hastobe.emobilitycsms.dto.RateResponse;
import com.hastobe.emobilitycsms.service.DtoMockMaker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DefaultRateServiceTest {

    private static DefaultRateService rateService;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        rateService = new DefaultRateService();
    }

    @Test
    void calculateCost() throws ParseException {
        RateResponse response = RateResponse.builder()
                .overall(7.04)
                .components(RateDto.of(3.2769, 2.7666666666666666, 1))
                .build();
        assertEquals(response, rateService.calculateCost(DtoMockMaker.getRateDto(), DtoMockMaker.getCDRDto()));
    }
}