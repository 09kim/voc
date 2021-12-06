package com.teamf.voc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class DeliveryWorkerIncentive {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incentive_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "crr_id")
    @JsonBackReference(value = "crr_id")
    private CarrierInformation carrierInformation;

    private int commission;

}
