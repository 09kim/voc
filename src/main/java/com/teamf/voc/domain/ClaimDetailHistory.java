package com.teamf.voc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class ClaimDetailHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voc_history_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "claim_detail_id")
    @JsonBackReference(value = "claim_detail_id")
    private ClaimDetail claimDetail;

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
