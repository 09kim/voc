package com.teamf.voc.controller;

import com.teamf.voc.domain.Compensation;
import com.teamf.voc.service.ClaimDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claim/detail")
@RequiredArgsConstructor
@Slf4j
public class ClaimDetailController {

    private final ClaimDetailService claimDetailService;

    @PostMapping("/save/{claimId}")
    public ResponseEntity<String> insertCompensation(@RequestBody Compensation compensation, @PathVariable Long claimId) {

        claimDetailService.createClaimDetail(claimId);

        return ResponseEntity.ok().body("ok");

    }

}
