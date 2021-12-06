package com.teamf.voc.controller;

import com.teamf.voc.domain.Admin;
import com.teamf.voc.domain.Claim;
import com.teamf.voc.service.AdminService;
import com.teamf.voc.service.CarrierInformationService;
import com.teamf.voc.service.ClaimService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/claim")
@Slf4j
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @Autowired
    private CarrierInformationService carrierInformationService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/findAll")
    public List<Claim> getClaimService() {
        return claimService.findClaims();
    }

//    @PostMapping("/saveClaim")
//    public List<Claim> insertClaim() {
//        Long admin = adminService.createAdmin();
//        Long crrInformation = carrierInformationService.createCrrInformation();
//
//        Claim claim = claimService.createClaim(admin, crrInformation);
//
//        return claimService.findClaims();
//    }

    @PostMapping("/saveClaim")
    public ResponseEntity<String> insertClaim(@RequestBody Claim claim) {

        Long admin = adminService.createAdmin();
        Long crrInformation = carrierInformationService.createCrrInformation();

        claimService.createClaim(admin, crrInformation, claim);

        return ResponseEntity.ok().body("ok");
    }




}