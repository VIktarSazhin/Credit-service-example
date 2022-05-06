package com.example.creditservice.mapper;

import com.example.creditservice.dto.LoanRequestDto;
import com.example.creditservice.entity.CreditProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreditProductMapper {

    CreditProductMapper INSTANCE = Mappers.getMapper(CreditProductMapper.class);

    @Mapping(target = "minTerm", expression = "java(getMinTerm())")
    @Mapping(target = "maxTerm", expression = "java(getMaxTerm())")
    @Mapping(target = "minSum", expression = "java(getMinSum())")
    @Mapping(target = "maxSum", expression = "java(getMaxSum())")
    CreditProduct toCreditProduct(LoanRequestDto loanRequestDto);

    default int getMinTerm() {
        return 6;
    }

    default int getMaxTerm() {
        return 36;
    }

    default int getMinSum() {
        return 500;
    }

    default int getMaxSum() {
        return 100000;
    }
}
