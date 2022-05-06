package com.example.creditservice.controller;

import com.example.creditservice.dto.LoanInfoDto;
import com.example.creditservice.dto.LoanRequestDto;
import com.example.creditservice.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/loan-service")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/loan/info/{id}")
    public LoanInfoDto getLoanInfo(@PathVariable Long id) {
        return loanService.getLoanInfoById(id);
    }

    @PostMapping("/loan/new")
    public LoanRequestDto createLoan(@RequestBody LoanRequestDto loanRequestDto) {
        return loanService.createNewLoan(loanRequestDto);
    }
}
