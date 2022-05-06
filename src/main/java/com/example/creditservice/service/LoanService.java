package com.example.creditservice.service;

import com.example.creditservice.dto.LoanInfoDto;
import com.example.creditservice.dto.LoanRequestDto;

public interface LoanService {
    LoanInfoDto getLoanInfoById(Long id);

    LoanRequestDto createNewLoan(LoanRequestDto loanRequestDto);
}
