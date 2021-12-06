package com.teamf.voc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teamf.voc.domain.enums.BoolCheck;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class CompensationPenalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "compensation_id")
    @JsonBackReference(value = "compensation")
    private Compensation compensation;

    private int code;

    @Enumerated(EnumType.STRING)
    private BoolCheck is_active;
    @Enumerated(EnumType.STRING)
    private BoolCheck is_push;

    private LocalDateTime reg_date;

}
