package com.teamf.voc;

import com.teamf.voc.domain.Admin;
import com.teamf.voc.repository.AdminRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class VocApplication {

	public static void main(String[] args) {
		SpringApplication.run(VocApplication.class, args);


	}

}
