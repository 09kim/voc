package com.teamf.voc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class ClaimDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_detail_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "voc_id")
    @JsonBackReference
    private Claim claim;

    @OneToMany(mappedBy = "claim")
    @JsonBackReference
    private List<ClaimDetailHistory> claimDetailHistoryList = new ArrayList<>();

    @Lob
    private String attributable_content;

    @Lob
    private String crr_objection;

    private LocalDateTime reg_date_attributable;
    private LocalDateTime reg_date_crr_objection;
    private LocalDateTime update_date_attributable;
    private LocalDateTime update_date_crr_objection;

    public static ClaimDetail createClaimDetail(Claim claim) {
        ClaimDetail claimDetail = new ClaimDetail();
        claimDetail.setClaim(claim);
        claimDetail.setAttributable_content("냉동차 에어컨 고장");
        claimDetail.setReg_date_attributable(LocalDateTime.now());
        claimDetail.setReg_date_crr_objection(LocalDateTime.now());
        claimDetail.setUpdate_date_attributable(LocalDateTime.now());
        claimDetail.setUpdate_date_crr_objection(LocalDateTime.now());

        return claimDetail;
    }


}
