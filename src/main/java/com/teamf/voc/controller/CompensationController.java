package com.teamf.voc.controller;

import com.teamf.voc.domain.Claim;
import com.teamf.voc.domain.Compensation;
import com.teamf.voc.service.ClaimService;
import com.teamf.voc.service.CompensationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compensation")
@RequiredArgsConstructor
@Slf4j
public class CompensationController {

    private final CompensationService compensationService;

    @PostMapping("/save/{claimId}")
    public ResponseEntity<String> insertCompensation(@RequestBody Compensation compensation, @PathVariable Long claimId) {

        compensationService.createCompensation(claimId);

        return ResponseEntity.ok().body("ok");

    }

    @GetMapping("/vocList")
    public List<Compensation> findVocList() {
        for (Compensation claim : compensationService.findVocList()) {
            System.out.println("claim = " + claim.getClaim());
        }
       return compensationService.findVocList();
    }

}
