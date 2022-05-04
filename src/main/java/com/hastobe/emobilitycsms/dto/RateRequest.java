package com.hastobe.emobilitycsms.dto;

import lombok.Data;

@Data
public class RateRequest {
    private RateDto rate;
    private CDRDto cdr;
}
