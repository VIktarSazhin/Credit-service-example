package com.example.creditservice.mapper;

import com.example.creditservice.dto.LoanRequestDto;
import com.example.creditservice.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {

    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    UserInfo toUserInfo(LoanRequestDto loanRequestDto);
}
