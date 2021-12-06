package com.teamf.voc.service;

import com.teamf.voc.domain.ClaimDetail;
import com.teamf.voc.domain.ClaimDetailHistory;
import com.teamf.voc.repository.ClaimDetailHistoryRepository;
import com.teamf.voc.repository.ClaimDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClaimDetailHistoryService {

    private final ClaimDetailHistoryRepository claimDetailHistoryRepository;
    private final ClaimDetailRepository claimDetailRepository;

    public List<ClaimDetailHistory> findClaimDetails() {
        return claimDetailHistoryRepository.findAll();
    }
    public ClaimDetailHistory createClaimDetailHistory(Long claimDetailId) {

        ClaimDetailHistory claimDetailHistory = new ClaimDetailHistory();

        ClaimDetail claimDetail = claimDetailRepository.findOne(claimDetailId);

        claimDetailHistory.setClaimDetail(claimDetail);

        claimDetailHistoryRepository.save(claimDetailHistory);

        return claimDetailHistory;

    }

}
