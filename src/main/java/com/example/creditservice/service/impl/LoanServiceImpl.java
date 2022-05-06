package com.example.creditservice.service.impl;

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
import com.example.creditservice.service.LoanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    private final UserInfoRepository userInfoRepository;

    private final CreditProductRepository creditProductRepository;

    private final LoanMapper loanMapper;

    private final UserInfoMapper userInfoMapper;

    private final CreditProductMapper creditProductMapper;

    @Override
    public LoanInfoDto getLoanInfoById(Long id) {
        Loan loan = loanRepository.getById(id);
        return loanMapper.toLoanInfoDto(loan);
    }

    @Transactional
    @Override
    public LoanRequestDto createNewLoan(LoanRequestDto loanRequestDto) {
        Loan loan = loanMapper.toLoan(loanRequestDto);
        UserInfo userInfo = userInfoMapper.toUserInfo(loanRequestDto);
        CreditProduct creditProduct = creditProductMapper.toCreditProduct(loanRequestDto);
        userInfoRepository.save(userInfo);
        creditProductRepository.save(creditProduct);
        loanRepository.save(loan);
        return loanMapper.toLoanRequestDto(loan, creditProduct, userInfo);
    }
}
