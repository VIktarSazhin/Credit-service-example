package com.example.creditservice.service.impl;

import com.example.creditservice.InitDataForTest;
import com.example.creditservice.dto.LoanInfoDto;
import com.example.creditservice.dto.LoanRequestDto;
import com.example.creditservice.entity.CreditProduct;
import com.example.creditservice.entity.Loan;
import com.example.creditservice.entity.UserInfo;
import com.example.creditservice.mapper.CreditProductMapper;
import com.example.creditservice.mapper.LoanMapper;
import com.example.creditservice.mapper.UserInfoMapper;
import com.example.creditservice.repository.CreditProductRepository;
import com.example.creditservice.repository.LoanRepository;
import com.example.creditservice.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class LoanServiceImplTest {

    @Mock
    private CreditProductRepository creditProductRepository;

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private UserInfoRepository userInfoRepository;

    @Mock
    private LoanMapper loanMapper;

    @Mock
    private UserInfoMapper userInfoMapper;

    @Mock
    private CreditProductMapper creditProductMapper;

    @InjectMocks
    private LoanServiceImpl loanService;

    @Test
    void getLoanInfoByIdTest() {
        Loan loan = InitDataForTest.createLoanTest();
        LoanInfoDto loanInfoDto = InitDataForTest.createLoanInfoDto();

        lenient().when(loanService.getLoanInfoById(loan.getId())).thenReturn(loanInfoDto);
        lenient().when(loanMapper.toLoanInfoDto(loan)).thenReturn(loanInfoDto);

        LoanInfoDto actualLoanInfoDto = loanService.getLoanInfoById(1L);

        assertEquals(loanInfoDto, actualLoanInfoDto);
    }

    @Test
    void createNewLoanTest() {
        Loan loan = InitDataForTest.createLoanTest();
        CreditProduct creditProduct = InitDataForTest.createCreditProductTest();
        UserInfo userInfo = InitDataForTest.createUserInfoTest();

        when(loanRepository.save(any())).thenReturn(loan);
        when(creditProductRepository.save(any())).thenReturn(creditProduct);
        when(userInfoRepository.save(any())).thenReturn(userInfo);

        when(loanMapper.toLoan(any())).thenReturn(InitDataForTest.createLoanTest());
        when(creditProductMapper.toCreditProduct(any())).thenReturn(InitDataForTest.createCreditProductTest());
        when(userInfoMapper.toUserInfo(any())).thenReturn(InitDataForTest.createUserInfoTest());

        when(loanService.createNewLoan(any())).thenReturn(InitDataForTest.createLoanRequestDto());

        LoanRequestDto loanRequestDto = InitDataForTest.createLoanRequestDto();
        LoanRequestDto actualLoanRequestDto = loanService.createNewLoan(loanRequestDto);

        assertEquals(loanRequestDto, actualLoanRequestDto);
    }
}