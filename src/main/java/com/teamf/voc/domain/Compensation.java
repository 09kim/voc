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
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compensation_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "voc_id")
    @JsonBackReference(value = "voc_id")
    private Claim claim;

    @OneToOne(fetch = LAZY, mappedBy = "compensation",cascade = CascadeType.ALL)
    @JsonBackReference(value = "penalty_id")
    private CompensationPenalty compensationPenalty;

    private int compensation_amount;

    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private BoolCheck is_payment;
    @Enumerated(EnumType.STRING)
    private BoolCheck is_sign;

    private LocalDateTime reg_date;
    private LocalDateTime update_date;

}
