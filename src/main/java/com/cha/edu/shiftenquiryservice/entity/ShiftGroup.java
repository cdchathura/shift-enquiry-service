package com.cha.edu.shiftenquiryservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table(name = "shift_group")
public class ShiftGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Code in ShiftGroup is mandatory")
    @Column(name = "code")
    private String code;


}
