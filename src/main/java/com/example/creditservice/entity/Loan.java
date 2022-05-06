package com.example.creditservice.entity;

import com.example.creditservice.entity.constant.CreditProgram;
import com.example.creditservice.entity.constant.CreditStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_generator")
    @SequenceGenerator(allocationSize = 1, name = "loan_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "credit_program")
    @Enumerated(EnumType.STRING)
    private CreditProgram creditProgram;

    @Column(name = "credit_status")
    @Enumerated(EnumType.STRING)
    private CreditStatus creditStatus;

    @Column(name = "sum")
    private int sum;

    @Column(name = "term")
    private int term;

    @Column(name = "monthly_payment")
    private int monthlyPayment;

    @Column(name = "interest_rate")
    private int interestRate;

    @Column(name = "date_of_application")
    private LocalDate dateOfApplication;

    @Column(name = "date_of_start")
    private LocalDate dateOfStart;

    @Column(name = "date_of_end")
    private LocalDate dateOfEnd;

    @Column(name = "credit_account")
    private int creditAccount;

    @OneToOne
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    @OneToOne
    @JoinColumn(name = "credit_product_id")
    private CreditProduct creditProduct;
}
