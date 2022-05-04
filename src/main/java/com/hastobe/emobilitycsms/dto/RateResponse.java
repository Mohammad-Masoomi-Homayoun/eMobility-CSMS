package com.hastobe.emobilitycsms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RateResponse {

    private double overall;
    private RateDto components;
}
