package com.teamf.voc.service;


import com.teamf.voc.domain.Compensation;
import com.teamf.voc.repository.CompensationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompensationService {

    private final CompensationRepository compensationRepository;


    public List<Compensation> findCompensations() {
        return compensationRepository.findAll();
    }



}
