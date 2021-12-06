package com.teamf.voc.service;

import com.teamf.voc.domain.Admin;
import com.teamf.voc.domain.CarrierInformation;
import com.teamf.voc.domain.Claim;
import com.teamf.voc.repository.AdminRepository;
import com.teamf.voc.repository.CarrierInformationRepository;
import com.teamf.voc.repository.ClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClaimService {

    private final AdminRepository adminRepository;
    private final ClaimRepository claimRepository;
    private final CarrierInformationRepository carrierInformationRepository;

    //클레임 전체 조회
    public List<Claim> findClaims() {
        return claimRepository.findAll();
    }

    public Claim createClaim(Long adminId, Long carrierInformationId) {

        Claim claim = new Claim();
        Admin admin = adminRepository.findOne(adminId);
        CarrierInformation carrierInformation = carrierInformationRepository.findOne(carrierInformationId);

        claim.setAdmin(admin);
        claim.setCarrierInformation(carrierInformation);
        claim.setReg_date(LocalDateTime.now());
        claim.setUpdate_date(LocalDateTime.now());

        return claim;

    }







}
