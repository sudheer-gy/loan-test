package com.test.loan.model;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    private String name;
    private String ssn;
    private LocalDate dob;
    private BigDecimal principal;
    private BigDecimal rate;
    private LoanType type;
    private long term;

    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    public BigDecimal getAnnualPercentageRate() {
        BigDecimal numerator = getTotalPaid().divide(principal, RoundingMode.HALF_UP);
        BigDecimal perDay = numerator.divide(rate, RoundingMode.HALF_UP);
        return perDay.multiply(BigDecimal.valueOf(365)).multiply(HUNDRED).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getTotalPaid(){
        return getInterestPaid().add(type.getFees());
    }

    private BigDecimal getInterestPaid(){
        BigDecimal value = principal.multiply(rate);
        BigDecimal interest = value.divide(HUNDRED, RoundingMode.HALF_UP);
        return interest.setScale(2, RoundingMode.HALF_UP);
    }
}
