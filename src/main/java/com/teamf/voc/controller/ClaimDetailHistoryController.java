package com.teamf.voc.controller;

import com.teamf.voc.domain.ClaimDetail;
import com.teamf.voc.domain.ClaimDetailHistory;
import com.teamf.voc.service.ClaimDetailHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/api/claim/detail/history")
public class ClaimDetailHistoryController {

    private final ClaimDetailHistoryService claimDetailHistoryService;

    @PostMapping("/save/{claimDetailId}")
    public ResponseEntity<String> save(@RequestBody ClaimDetailHistory claimDetailHistory, @PathVariable Long claimDetailId) {

        claimDetailHistoryService.createClaimDetailHistory(claimDetailId);

        return ResponseEntity.ok().body("ok");
    }

}
