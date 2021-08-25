package com.test.loan.service;

import com.test.loan.api.request.LoanRequest;
import com.test.loan.model.Loan;
import com.test.loan.model.LoanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private final List<Loan> loanData;

    @Autowired
    public LoanService(List<Loan> loanData) {
        this.loanData = loanData;
    }

    public List<Loan> getAll(){
        return loanData;
    }

    public void createLoan(LoanRequest request){
        Loan loan = requestToLoan(request);
        loanData.add(loan);
    }

    private Loan requestToLoan(LoanRequest request){
        return Loan.builder()
                .dob(request.getDob())
                .name(request.getName())
                .principal(request.getPrincipal())
                .rate(request.getRate())
                .ssn(request.getSsn())
                .term(request.getTerm())
                .type(LoanType.fromType(request.getType()))
                .build();
    }
}
