package com.teamf.voc.domain;

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
    @GeneratedValue
    @Column(name = "penalty_id")
    private Long id;

    @OneToOne(fetch = LAZY, mappedBy = "compensationPenalty")
    private Compensation compensation;

    private int code;

    @Enumerated(EnumType.STRING)
    private BoolCheck is_active;
    @Enumerated(EnumType.STRING)
    private BoolCheck is_push;

    private LocalDateTime reg_date;

}
