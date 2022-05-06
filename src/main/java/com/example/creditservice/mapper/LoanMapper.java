package com.example.creditservice.mapper;

import com.example.creditservice.dto.LoanInfoDto;
import com.example.creditservice.dto.LoanRequestDto;
import com.example.creditservice.entity.CreditProduct;
import com.example.creditservice.entity.Loan;
import com.example.creditservice.entity.UserInfo;
import com.example.creditservice.entity.constant.CreditProgram;
import com.example.creditservice.entity.constant.CreditStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;

@Mapper(componentModel = "spring", uses = {UserInfoMapper.class, CreditProductMapper.class})
public interface LoanMapper {

    LoanInfoDto toLoanInfoDto(Loan loan);

    @Mapping(target = "userId", expression = "java(loan.getUserId())")
    @Mapping(target = "id", expression = "java(loan.getId())")
    LoanRequestDto toLoanRequestDto(Loan loan, CreditProduct creditProduct, UserInfo userInfo);

    @Mapping(target = "dateOfApplication", expression = "java(getDayNow())")
    @Mapping(target = "dateOfStart", expression = "java(getDayNow())")
    @Mapping(target = "dateOfEnd", expression = "java(setDayOfEnd(loanRequestDto))")
    @Mapping(target = "creditProgram", expression = "java(setCreditProgram())")
    @Mapping(target = "creditStatus", expression = "java(setCreditStatus())")
    @Mapping(target = "monthlyPayment", expression = "java(setMonthlyPayment(loanRequestDto))")
    @Mapping(target = "userInfo", expression = "java(setUserInfo(loanRequestDto))")
    @Mapping(target = "creditProduct", expression = "java(setCreditProduct(loanRequestDto))")
    Loan toLoan(LoanRequestDto loanRequestDto);

    default LocalDate getDayNow() {
        return LocalDate.now();
    }

    default LocalDate setDayOfEnd(LoanRequestDto loanRequestDto) {
        return LocalDate.now().plusMonths(loanRequestDto.getTerm());
    }

    default CreditProgram setCreditProgram() {
        return CreditProgram.CONSUMER_CREDIT;
    }

    default CreditStatus setCreditStatus() {
        return CreditStatus.ACTIVE;
    }

    default int setMonthlyPayment(LoanRequestDto loanRequestDto) {
        return loanRequestDto.getSum() / loanRequestDto.getTerm();
    }

    default UserInfo setUserInfo(LoanRequestDto loanRequestDto) {
        return UserInfoMapper.INSTANCE.toUserInfo(loanRequestDto);
    }

    default CreditProduct setCreditProduct(LoanRequestDto loanRequestDto) {
        return CreditProductMapper.INSTANCE.toCreditProduct(loanRequestDto);
    }
}
