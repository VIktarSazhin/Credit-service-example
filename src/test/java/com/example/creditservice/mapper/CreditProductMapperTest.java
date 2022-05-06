package com.example.creditservice.mapper;

import com.example.creditservice.InitDataForTest;
import com.example.creditservice.dto.LoanRequestDto;
import com.example.creditservice.entity.CreditProduct;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditProductMapperTest {

    private final CreditProductMapper creditProductMapper = Mappers.getMapper(CreditProductMapper.class);

    @Test
    void mappingToCreditProductTest() {
        LoanRequestDto loanRequestDto = InitDataForTest.createLoanRequestDto();
        CreditProduct creditProduct = InitDataForTest.createCreditProductTest();
        CreditProduct actualCreditProduct = creditProductMapper.toCreditProduct(loanRequestDto);

        assertEquals(creditProduct, actualCreditProduct);
    }
}