package com.hastobe.emobilitycsms.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hastobe.emobilitycsms.utils.CustomDoubleSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
public class RateDto {
    @NotNull
    @JsonSerialize(using = CustomDoubleSerializer.class)
    private double energy;
    @NotNull
    @JsonSerialize(using = CustomDoubleSerializer.class)
    private double time;
    @NotNull
    private int transaction;
}
