package com.teamf.voc.domain;

import com.teamf.voc.domain.enums.CustomerOrDeliveryWorker;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class CarrierInformation {

    @Id @GeneratedValue
    @Column(name = "crr_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private CustomerOrDeliveryWorker type; // 배송타입 (고객사(C) / 배송기사(D))

    @OneToMany(mappedBy = "carrierInformation")
    private List<Claim> claimList = new ArrayList<>();

    @Embedded
    private Address address; // 사업장 소재지

    private String tel_no;

    private int salary; // 기본급여 (배송기사 일때만 해당)

    private LocalDateTime reg_date;



}
