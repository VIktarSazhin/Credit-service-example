package com.example.creditservice.entity;

import com.example.creditservice.entity.constant.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Table(name = "credit_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class CreditProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_product_generator")
    @SequenceGenerator(allocationSize = 1, name = "credit_product_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "min_term")
    private int minTerm;

    @Column(name = "max_term")
    private int maxTerm;

    @Column(name = "max_sum")
    private int maxSum;

    @Column(name = "min_sum")
    private int minSum;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;
}
