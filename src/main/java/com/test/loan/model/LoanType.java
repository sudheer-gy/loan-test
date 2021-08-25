package com.test.loan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;

@AllArgsConstructor
public enum LoanType {
    STUDENT(BigDecimal.ZERO),
    AUTO(BigDecimal.valueOf(500)),
    PERSONAL(BigDecimal.valueOf(750)),
    MORTGAGE(BigDecimal.valueOf(1500));

    @Getter
    private final BigDecimal fees;

    public static LoanType fromType(String type){
        return Arrays.stream(LoanType.values())
                .filter(t-> t.name().equalsIgnoreCase(type))
                .findFirst()
                .orElse(null);
    }


}
