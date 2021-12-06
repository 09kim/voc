package com.teamf.voc.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class DeliveryWorkerIncentive {

    @Id @GeneratedValue
    @Column(name = "incentive_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "crr_id")
    private CarrierInformation carrierInformation;

    private int commission;

}
