package com.hastobe.emobilitycsms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class CDRDto {
    @NotNull
    private long meterStart;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Date timestampStart;
    @NotNull
    private long meterStop;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Date timestampStop;

    @JsonIgnore
    public Double getDurationInHour() {
        return (timestampStop.getTime() - timestampStart.getTime()) / 1000.0 / 60.0 / 60.0;
    }

    @JsonIgnore
    public Double getConsumedEnergyInKilo() {
        return (meterStop - meterStart) / 1000.0 ;
    }
}

