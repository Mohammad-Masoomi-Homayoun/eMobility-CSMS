package com.hastobe.emobilitycsms.service.impl;

import com.hastobe.emobilitycsms.dto.CDRDto;
import com.hastobe.emobilitycsms.dto.RateDto;
import com.hastobe.emobilitycsms.dto.RateRequest;
import com.hastobe.emobilitycsms.dto.RateResponse;
import com.hastobe.emobilitycsms.service.RateService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DefaultRateService implements RateService {

    @Override
    public Mono<RateResponse> calculateRate(RateRequest request) {
        return Mono.just(calculateCost(request.getRate(), request.getCdr()));
    }

    public RateResponse calculateCost(RateDto rateDto, CDRDto cdrDto) {

        double consumedEnergyCost = cdrDto.getConsumedEnergyInKilo() * rateDto.getEnergy();
        double consumedTimeCost = cdrDto.getDurationInHour() * rateDto.getTime();
        int transactionCost = rateDto.getTransaction();

        double totalCost = consumedEnergyCost + consumedTimeCost + transactionCost;

        return RateResponse.builder()
                .overall(new BigDecimal(totalCost).setScale(2, RoundingMode.HALF_UP).doubleValue())
                .components(RateDto.of(consumedEnergyCost, consumedTimeCost, transactionCost))
                .build();
    }
}
