package com.test.loan.api.request;

import com.test.loan.model.LoanType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LoanRequest {
    private String name;
    private String ssn;
    private LocalDate dob;
    private BigDecimal principal;
    private BigDecimal rate;
    private String type;
    private long term;

}
