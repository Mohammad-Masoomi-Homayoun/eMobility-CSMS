package com.hastobe.emobilitycsms.controller;

import com.hastobe.emobilitycsms.dto.RateRequest;
import com.hastobe.emobilitycsms.dto.RateResponse;
import com.hastobe.emobilitycsms.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rate")
public class RateController {

    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping
    public Mono<RateResponse> calculateRate(@RequestBody RateRequest rateRequest) {
        return rateService.calculateRate(rateRequest);
    }
}