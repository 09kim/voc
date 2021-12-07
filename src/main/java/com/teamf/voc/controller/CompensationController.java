package com.teamf.voc.controller;

import com.teamf.voc.domain.Compensation;
import com.teamf.voc.domain.enums.BoolCheck;
import com.teamf.voc.domain.enums.CustomerOrDeliveryWorker;
import com.teamf.voc.service.CompensationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/findCompensationList")
    public List<findCompensationDto> findCompensationList() {

        List<Compensation> compensationList = compensationService.findCompensations();

        List<findCompensationDto> result = compensationList.stream().
                map(o -> new findCompensationDto(o))
                .collect(Collectors.toList());

        return result;
    }

    @Data
    static class findCompensationDto {

        private Long claimId;
        private String claimName;
        private String claim_tel_no;
        private String claim_content;
        private BoolCheck claim_statusCd;
        private BoolCheck claim_is_delivery_open;
        private CustomerOrDeliveryWorker claim_attributableCd;
        private LocalDateTime claim_reg_date;


        private Long compensation_id;
        private int compensation_amount;
        private LocalDateTime compensation_payment_date;
        private BoolCheck compensation_is_payment;
        private BoolCheck compensation_is_sign;
        private LocalDateTime compensation_reg_date;

        public findCompensationDto(Compensation compensation) {

            compensation_id = compensation.getId();
            compensation_amount = compensation.getCompensation_amount();
            compensation_is_payment = compensation.getIs_payment();
            compensation_payment_date = compensation.getPaymentDate();
            compensation_is_sign = compensation.getIs_sign();
            compensation_reg_date = compensation.getReg_date();

            claimId = compensation.getClaim().getId();
            claimName = compensation.getClaim().getName();
            claim_tel_no = compensation.getClaim().getTel_no();
            claim_content = compensation.getClaim().getClaim_content();
            claim_statusCd = compensation.getClaim().getClaim_status_code();
            claim_is_delivery_open = compensation.getClaim().getIs_delivery_open();
            claim_attributableCd = compensation.getClaim().getAttributableCd();
            claim_reg_date = compensation.getClaim().getReg_date();

        }

    }

}
