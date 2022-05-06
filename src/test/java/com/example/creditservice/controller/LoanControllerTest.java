package com.example.creditservice.controller;

import com.example.creditservice.InitDataForTest;
import com.example.creditservice.dto.LoanInfoDto;
import com.example.creditservice.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class LoanControllerTest {

    @MockBean
    private LoanService loanService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveNewLoanTest() throws Exception {
        when(loanService.createNewLoan(Mockito.any()))
                .thenReturn(InitDataForTest.createLoanRequestDto());
        mockMvc.perform(post("/loan-service/loan/new")
                        .content(objectMapper.writeValueAsString(InitDataForTest.createLoanRequestDto()))
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(InitDataForTest.createLoanRequestDto())));
    }

    @Test
    void getLoanByLoanIdTest() throws Exception {
        LoanInfoDto loanInfoDto = InitDataForTest.createLoanInfoDto();
        when(loanService.getLoanInfoById(10L)).thenReturn(loanInfoDto);
        mockMvc.perform(get("/loan-service/loan/info/10"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(loanInfoDto)));
    }
}
