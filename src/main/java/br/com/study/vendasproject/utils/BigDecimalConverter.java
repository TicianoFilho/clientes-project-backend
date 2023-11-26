package br.com.study.vendasproject.utils;

import java.math.BigDecimal;

public class BigDecimalConverter {

    public static BigDecimal convert(String value) {
        if (value == null) {
            return null;
        }
        String convertedValue = value.replace("\\.", "").replace(",", ".");
        return new BigDecimal(convertedValue);
    }
}
