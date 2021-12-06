package com.teamf.voc.service;

import com.teamf.voc.domain.Admin;
import com.teamf.voc.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public Long createAdmin() {
        Admin admin = Admin.createAdmin();
        adminRepository.save(admin);
        return admin.getId();
    }


}
