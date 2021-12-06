package com.teamf.voc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Admin {

    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private Long id;

    private String name;
    private String tel_no;
    private String mobile;

    private LocalDateTime reg_date;   // 입사일
    private LocalDateTime leave_date; // 퇴사일

    public static Admin createAdmin() {
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setTel_no("02-0000-0000");
        admin.setMobile("010-5520-1984");
        admin.setReg_date(LocalDateTime.now());
        return admin;
    }

}
