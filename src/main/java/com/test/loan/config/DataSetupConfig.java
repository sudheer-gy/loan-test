package com.test.loan.config;

import com.test.loan.model.Loan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSetupConfig {

    @Bean
    public List<Loan> loadData(){
        return new ArrayList<>();
    }
}
