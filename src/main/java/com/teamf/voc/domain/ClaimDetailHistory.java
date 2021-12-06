package com.teamf.voc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class ClaimDetailHistory {

    @Id
    @GeneratedValue
    @Column(name = "voc_history_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "claim_detail_id")
    private ClaimDetail claimDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voc_id")
    private Claim claim;

    @Lob
    private String attributable_content;

    @Lob
    private String crr_objection;

    private LocalDateTime reg_date_attributable;
    private LocalDateTime reg_date_crr_objection;
    private LocalDateTime update_date_attributable;
    private LocalDateTime update_date_crr_objection;
    private LocalDateTime reg_date;


}
