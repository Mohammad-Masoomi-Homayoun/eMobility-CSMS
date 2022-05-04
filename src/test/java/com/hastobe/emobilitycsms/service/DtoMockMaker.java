package com.hastobe.emobilitycsms.service;

import com.hastobe.emobilitycsms.dto.CDRDto;
import com.hastobe.emobilitycsms.dto.RateDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DtoMockMaker {

    public static CDRDto getCDRDto() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        return CDRDto.builder()
                .meterStart(1204307)
                .timestampStart(formatter.parse("2021-04-05T10:04:00Z"))
                .meterStop(1215230)
                .timestampStop(formatter.parse("2021-04-05T11:27:00Z"))
                .build();
    }

    public static RateDto getRateDto() {
        return RateDto.builder()
                .energy(0.3)
                .time(2)
                .transaction(1)
                .build();
    }
}
