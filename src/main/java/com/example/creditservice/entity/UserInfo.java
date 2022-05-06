package com.example.creditservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_generator")
    @SequenceGenerator(allocationSize = 1, name = "user_info_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "company")
    private String company;

    @Column(name = "position")
    private String position;

    @Column(name = "address_company")
    private String addressCompany;

    @Column(name = "work_phone")
    private Long workPhone;
}
