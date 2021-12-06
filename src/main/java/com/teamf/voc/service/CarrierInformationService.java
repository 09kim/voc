package com.teamf.voc.service;

import com.teamf.voc.domain.CarrierInformation;
import com.teamf.voc.repository.CarrierInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CarrierInformationService {

    private final CarrierInformationRepository carrierInformationRepository;

    public Long createCrrInformation() {
        CarrierInformation crrInformation = CarrierInformation.createCrrInformation();
        carrierInformationRepository.save(crrInformation);
        return crrInformation.getId();
    }



}
