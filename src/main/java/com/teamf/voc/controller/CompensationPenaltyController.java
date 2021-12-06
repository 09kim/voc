package com.teamf.voc.controller;

import com.teamf.voc.domain.Compensation;
import com.teamf.voc.domain.CompensationPenalty;
import com.teamf.voc.service.ClaimService;
import com.teamf.voc.service.CompensationPenaltyService;
import com.teamf.voc.service.CompensationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compensation/penalty")
@RequiredArgsConstructor
@Slf4j
public class CompensationPenaltyController {

    private final CompensationService compensationService;
    private final CompensationPenaltyService compensationPenaltyService;

    @PostMapping("/save/{compensationId}")
    public ResponseEntity<String> insertCompensationPenalty(@RequestBody Compensation compensation, @PathVariable Long compensationId) {

        compensationPenaltyService.createCompensationPenalty(compensationId);

        return ResponseEntity.ok().body("ok");

    }

}
