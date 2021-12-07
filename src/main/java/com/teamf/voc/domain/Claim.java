package com.teamf.voc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teamf.voc.domain.enums.BoolCheck;
import com.teamf.voc.domain.enums.CustomerOrDeliveryWorker;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Claim {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voc_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "admin_id")
    @JsonBackReference(value = "admin_id")
    private Admin admin;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "crr_id")
    @JsonBackReference(value = "crr_id")
    private CarrierInformation carrierInformation;

    @OneToOne(fetch = LAZY, mappedBy = "claim", cascade = CascadeType.ALL)
    @JsonBackReference(value = "claimDetail")
    private ClaimDetail claimDetail;

    @OneToOne(fetch = LAZY, mappedBy = "claim", cascade = CascadeType.ALL)
    @JsonBackReference(value = "compensation")
    private Compensation compensation;

    private String name;

    private String tel_no;

    @Lob
    private String claim_content;

    @Enumerated(EnumType.STRING)
    private BoolCheck claim_status_code; // 클레임 처리 상태코드 Y/N

    @Enumerated(EnumType.STRING)
    private BoolCheck is_delivery_open; // 기사 열람 및 확인 여부 Y/N

    @Enumerated(EnumType.STRING)
    private CustomerOrDeliveryWorker attributableCd; // 최초 귀책자(고객사(C) / 배송기사(D))

    @Enumerated(EnumType.STRING)
    private BoolCheck is_crr_objection; // 고객사 및 기사 이의제기 여부 Y/N

    @Enumerated(EnumType.STRING)
    private CustomerOrDeliveryWorker final_attribution;

    @Enumerated(EnumType.STRING)
    private BoolCheck is_compensation;

    private LocalDateTime reg_date;    // 접수시간
    private LocalDateTime update_date; // 갱신시간

}
