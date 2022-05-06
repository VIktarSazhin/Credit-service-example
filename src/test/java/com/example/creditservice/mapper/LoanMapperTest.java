package com.example.creditservice.mapper;

import com.example.creditservice.InitDataForTest;
import com.example.creditservice.dto.LoanInfoDto;
import com.example.creditservice.dto.LoanRequestDto;
import com.example.creditservice.entity.CreditProduct;
import com.example.creditservice.entity.Loan;
import com.example.creditservice.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanMapperTest {

    private final LoanMapper loanMapper = Mappers.getMapper(LoanMapper.class);

    @Test
    void mappingToLoan() {
        LoanRequestDto loanRequestDto = InitDataForTest.createLoanRequestDto();
        Loan loan = InitDataForTest.createLoanTest();
        Loan actualLoan = loanMapper.toLoan(loanRequestDto);

        assertEquals(loan, actualLoan);
    }

    @Test
    void mappingToLoanRequestDto() {
        Loan loan = InitDataForTest.createLoanTest();
        CreditProduct creditProduct = InitDataForTest.createCreditProductTest();
        UserInfo userInfo = InitDataForTest.createUserInfoTest();
        LoanRequestDto loanRequestDto = InitDataForTest.createLoanRequestDto();
        LoanRequestDto actualLoanRequestDto = loanMapper.toLoanRequestDto(loan, creditProduct, userInfo);

        assertEquals(loanRequestDto, actualLoanRequestDto);
    }

    @Test
    void mappingToLoanInfoDto() {
        Loan loan = InitDataForTest.createLoanTest();
        LoanInfoDto loanInfoDto = InitDataForTest.createLoanInfoDto();
        LoanInfoDto actualLoanInfoDto = loanMapper.toLoanInfoDto(loan);

        assertEquals(loanInfoDto, actualLoanInfoDto);
    }

}