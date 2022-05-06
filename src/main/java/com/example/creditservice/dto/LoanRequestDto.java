package com.example.creditservice.dto;

import com.example.creditservice.entity.constant.Currency;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanRequestDto {

    private Long id;
    private Long userId;
    private int sum;
    private Currency currency;
    private int term;
    private int interestRate;
    private int creditAccount;
    private String name;
    private String surname;
    private String patronymic;
    private Long phoneNumber;
    private String company;
    private String position;
    private String addressCompany;
    private Long workPhone;
}
