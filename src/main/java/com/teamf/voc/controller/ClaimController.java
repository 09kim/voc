package com.teamf.voc.controller;

import com.teamf.voc.domain.Claim;
import com.teamf.voc.domain.enums.BoolCheck;
import com.teamf.voc.domain.enums.CustomerOrDeliveryWorker;
import com.teamf.voc.service.AdminService;
import com.teamf.voc.service.CarrierInformationService;
import com.teamf.voc.service.ClaimService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/claim")
@RequiredArgsConstructor
@Slf4j
public class ClaimController {

    private final ClaimService claimService;
    private final CarrierInformationService carrierInformationService;
    private final AdminService adminService;

    @GetMapping("/findAll")
    public List<Claim> getClaimService() {
        return claimService.findClaims();
    }

    @PostMapping("/save")
    public ResponseEntity<String> insertClaim(@RequestBody Claim claim) {

        Long admin = adminService.createAdmin();
        Long crrInformation = carrierInformationService.createCrrInformation();

        claimService.createClaim(admin, crrInformation, claim);

        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("/findVocList")
    public List<findVocDto> getVocList() {

        List<Claim> vocList = claimService.findVocList();
        List<findVocDto> result = vocList.stream().
                map(o -> new findVocDto(o))
                .collect(Collectors.toList());

        return result;
    }

    @Data
    static class findVocDto {

        private Long claimId;
        private String claimName;
        private String claim_tel_no;
        private String claim_content;
        private BoolCheck claim_statusCd;
        private BoolCheck claim_is_delivery_open;
        private CustomerOrDeliveryWorker claim_attributableCd;
        private LocalDateTime claim_reg_date;

        private Long detail_id;
        private String detail_attributable_content;
        private String crr_objection;
        private LocalDateTime detail_reg_date;

        private Long compensation_id;
        private int compensation_amount;
        private LocalDateTime compensation_payment_date;
        private BoolCheck compensation_is_payment;
        private BoolCheck compensation_is_sign;
        private LocalDateTime compensation_reg_date;

        private Long penalty_id;
        private BoolCheck penalty_is_push;
        private LocalDateTime penalty_reg_date;

        public findVocDto(Claim claim) {

            compensation_id = claim.getCompensation().getId();
            compensation_amount = claim.getCompensation().getCompensation_amount();
            compensation_is_payment = claim.getCompensation().getIs_payment();
            compensation_payment_date = claim.getCompensation().getPaymentDate();
            compensation_is_sign = claim.getCompensation().getIs_sign();
            compensation_reg_date = claim.getCompensation().getReg_date();

            penalty_id = claim.getCompensation().getCompensationPenalty().getId();
            penalty_is_push = claim.getCompensation().getCompensationPenalty().getIs_push();
            penalty_reg_date = claim.getCompensation().getCompensationPenalty().getReg_date();


            claimId = claim.getId();
            claimName = claim.getName();
            claim_tel_no = claim.getTel_no();
            claim_content = claim.getClaim_content();
            claim_statusCd = claim.getClaim_status_code();
            claim_is_delivery_open = claim.getIs_delivery_open();
            claim_attributableCd = claim.getAttributableCd();
            claim_reg_date = claim.getReg_date();


            detail_id = claim.getClaimDetail().getId();
            detail_attributable_content = claim.getClaimDetail().getAttributable_content();
            crr_objection = claim.getClaimDetail().getCrr_objection();
            detail_reg_date = claim.getClaimDetail().getReg_date_attributable();


        }

    }


}