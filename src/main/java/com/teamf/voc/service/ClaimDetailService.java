package com.teamf.voc.service;

import com.teamf.voc.domain.Claim;
import com.teamf.voc.domain.ClaimDetail;
import com.teamf.voc.domain.Compensation;
import com.teamf.voc.repository.ClaimDetailRepository;
import com.teamf.voc.repository.ClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClaimDetailService {


    private final ClaimRepository claimRepository;
    private final ClaimDetailRepository claimDetailRepository;

    public List<ClaimDetail> findClaimDetails() {
        return claimDetailRepository.findAll();
    }

    public ClaimDetail createClaimDetail(Long claimId) {

        Claim claim = claimRepository.findOne(claimId);

        ClaimDetail claimDetail = new ClaimDetail();
        claimDetail.setClaim(claim);
        claimDetailRepository.save(claimDetail);

        return claimDetail;

    }





}
