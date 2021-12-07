package com.teamf.voc.service;


import com.teamf.voc.domain.Compensation;
import com.teamf.voc.domain.CompensationPenalty;
import com.teamf.voc.domain.enums.BoolCheck;
import com.teamf.voc.repository.CompensationPenaltyRepository;
import com.teamf.voc.repository.CompensationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompensationPenaltyService {

    private final CompensationRepository compensationRepository;
    private final CompensationPenaltyRepository compensationPenaltyRepository;

    public List<CompensationPenalty> findCompensationPenaltyList() {
        return compensationPenaltyRepository.findAll();
    }

    public CompensationPenalty createCompensationPenalty(Long compensationId) {

        Compensation compensation = compensationRepository.findOne(compensationId);

        CompensationPenalty compensationPenalty = new CompensationPenalty();

        compensationPenalty.setCompensation(compensation);

        compensationPenaltyRepository.save(compensationPenalty);

        return compensationPenalty;

    }

    public CompensationPenalty findOne(Long id) {
        return compensationPenaltyRepository.findOne(id);
    }


    public void updateIsPush(Long id) {
        CompensationPenalty compensationPenalty = compensationPenaltyRepository.findOne(id);

        compensationPenalty.setIs_push(BoolCheck.Y);
        compensationPenalty.getCompensation().getClaim().setIs_delivery_open(BoolCheck.Y);
    }

}
