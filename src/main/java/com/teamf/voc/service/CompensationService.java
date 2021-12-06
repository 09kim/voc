package com.teamf.voc.service;


import com.teamf.voc.domain.Claim;
import com.teamf.voc.domain.Compensation;
import com.teamf.voc.repository.ClaimRepository;
import com.teamf.voc.repository.CompensationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompensationService {

    private final CompensationRepository compensationRepository;
    private final ClaimRepository claimRepository;

    public List<Compensation> findCompensations() {
        return compensationRepository.findAll();
    }

    public Compensation createCompensation(Long claimId) {

        Claim claim = claimRepository.findOne(claimId);

        Compensation compensation = new Compensation();
        compensation.setClaim(claim);

        compensationRepository.save(compensation);

        return compensation;

    }

    public List<Compensation> findVocList() {
        return compensationRepository.findVocList();
    }



}
