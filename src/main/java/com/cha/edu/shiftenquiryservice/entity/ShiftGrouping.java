package com.cha.edu.shiftenquiryservice.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "shift_grouping")
public class ShiftGrouping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shift_group_code")
    private String shiftGroupCode;

    @Column(name = "shift_code")
    private String shiftCode;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "shift", referencedColumnName = "code")

    })
    private Shift shift;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "shift_group", referencedColumnName = "code")

    })
    private ShiftGroup shiftGroup;
}
