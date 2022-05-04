package com.hastobe.emobilitycsms.service;

import com.hastobe.emobilitycsms.dto.RateRequest;
import com.hastobe.emobilitycsms.dto.RateResponse;
import reactor.core.publisher.Mono;

public interface RateService {

    Mono<RateResponse> calculateRate(RateRequest request);
}
