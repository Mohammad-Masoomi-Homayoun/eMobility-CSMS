package com.hastobe.emobilitycsms.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CustomDoubleSerializer extends JsonSerializer<Double> {

    @Override
    public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        if (null == value) {
            jgen.writeNull();
        } else {
            final String pattern = ".###";
            BigDecimal bd = new BigDecimal(value).setScale(3, RoundingMode.HALF_UP);
            final DecimalFormat myFormatter = new DecimalFormat(pattern);
            final String output = myFormatter.format(bd);
            jgen.writeNumber(output);
        }
    }
}
