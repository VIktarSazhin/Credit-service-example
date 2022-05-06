package com.example.creditservice;

import com.example.creditservice.dto.LoanInfoDto;
import com.example.creditservice.dto.LoanRequestDto;
import com.example.creditservice.entity.CreditProduct;
import com.example.creditservice.entity.Loan;
import com.example.creditservice.entity.UserInfo;
import com.example.creditservice.entity.constant.CreditProgram;
import com.example.creditservice.entity.constant.CreditStatus;
import com.example.creditservice.entity.constant.Currency;

import java.time.LocalDate;

public class InitDataForTest {

    public static Loan createLoanTest() {
        return Loan.builder()
                .id(1L)
                .creditAccount(10000)
                .creditProgram(CreditProgram.CONSUMER_CREDIT)
                .creditStatus(CreditStatus.ACTIVE)
                .term(24)
                .dateOfApplication(LocalDate.now())
                .dateOfStart(LocalDate.now())
                .dateOfEnd(LocalDate.now().plusMonths(24))
                .sum(700)
                .monthlyPayment(700 / 24)
                .interestRate(15)
                .userId(20L)
                .creditProduct(createCreditProductTest())
                .userInfo(createUserInfoTest())
                .build();
    }

    public static UserInfo createUserInfoTest() {
        return UserInfo.builder()
                .id(1L)
                .userId(20L)
                .company("Test company")
                .addressCompany("Test address")
                .position("Test position")
                .name("Test name")
                .surname("Test surname")
                .patronymic("Test patronymic")
                .workPhone(123456789L)
                .phoneNumber(123456789L)
                .build();
    }

    public static CreditProduct createCreditProductTest() {
        return CreditProduct.builder()
                .id(1L)
                .currency(Currency.BYN)
                .minSum(500)
                .maxSum(100000)
                .minTerm(6)
                .maxTerm(36)
                .build();
    }

    public static LoanInfoDto createLoanInfoDto() {
        return LoanInfoDto.builder()
                .id(1L)
                .creditAccount(10000)
                .creditProgram(CreditProgram.CONSUMER_CREDIT)
                .dateOfApplication(createLoanTest().getDateOfApplication())
                .dateOfStart(createLoanTest().getDateOfApplication())
                .sum(700)
                .interestRate(15)
                .term(24)
                .dateOfEnd(createLoanTest().getDateOfApplication().plusMonths(24))
                .monthlyPayment(700 / 24)
                .userId(20L)
                .build();
    }

    public static LoanRequestDto createLoanRequestDto() {
        return LoanRequestDto.builder()
                .id(1L)
                .userId(20L)
                .sum(700)
                .currency(Currency.BYN)
                .term(24)
                .interestRate(15)
                .creditAccount(10000)
                .name("Test name")
                .surname("Test surname")
                .patronymic("Test patronymic")
                .phoneNumber(123456789L)
                .company("Test company")
                .position("Test position")
                .addressCompany("Test address")
                .workPhone(123456789L)
                .build();
    }
}
