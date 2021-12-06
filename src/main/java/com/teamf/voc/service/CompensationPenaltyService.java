package com.teamf.voc.service;


import com.teamf.voc.domain.Claim;
import com.teamf.voc.domain.Compensation;
import com.teamf.voc.domain.CompensationPenalty;
import com.teamf.voc.repository.ClaimRepository;
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

}
