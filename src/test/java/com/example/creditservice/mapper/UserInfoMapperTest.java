package com.example.creditservice.mapper;

import com.example.creditservice.InitDataForTest;
import com.example.creditservice.dto.LoanRequestDto;
import com.example.creditservice.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInfoMapperTest {

    private final UserInfoMapper userInfoMapper = Mappers.getMapper(UserInfoMapper.class);

    @Test
    void mappingToUserInfo() {
        UserInfo userInfo = InitDataForTest.createUserInfoTest();
        LoanRequestDto loanRequestDto = InitDataForTest.createLoanRequestDto();
        UserInfo actualUserInfo = userInfoMapper.toUserInfo(loanRequestDto);

        assertEquals(userInfo, actualUserInfo);
    }
}