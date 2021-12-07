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
    @JsonBackReference(value = "voc_id")
    private Claim claim;

    @OneToMany(mappedBy = "claimDetail", cascade = CascadeType.ALL)
    @JsonBackReference(value = "claimDetailHistory")
    private List<ClaimDetailHistory> claimDetailHistoryList = new ArrayList<>();

    @Lob
    private String attributable_content;

    @Lob
    private String crr_objection;

    private LocalDateTime reg_date_attributable;
    private LocalDateTime reg_date_crr_objection;
    private LocalDateTime update_date_attributable;
    private LocalDateTime update_date_crr_objection;

}
