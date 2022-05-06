package com.example.creditservice.dto;

import com.example.creditservice.entity.constant.CreditProgram;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LoanInfoDto {

    private Long id;
    private Long userId;
    private CreditProgram creditProgram;
    private int term;
    private int interestRate;
    private int sum;
    private LocalDate dateOfApplication;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;
    private int monthlyPayment;
    private int creditAccount;
}
