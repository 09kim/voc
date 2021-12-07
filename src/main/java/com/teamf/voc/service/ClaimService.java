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

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClaimService {

    private final AdminRepository adminRepository;
    private final ClaimRepository claimRepository;
    private final CarrierInformationRepository carrierInformationRepository;

    public List<Claim> findClaims() {
        return claimRepository.findAll();
    }

    public Claim findOne(Long id) {
        return claimRepository.findOne(id);
    }

    public Claim createClaim(Long adminId, Long carrierInformationId, Claim claim) {

        Admin admin = adminRepository.findOne(adminId);
        CarrierInformation carrierInformation = carrierInformationRepository.findOne(carrierInformationId);

        claim.setAdmin(admin);
        claim.setCarrierInformation(carrierInformation);

        claimRepository.save(claim);

        return claim;

    }

    public List<Claim> findVocList() {
        return claimRepository.findVocList();
    }







}
