package com.teamf.voc;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.teamf.voc.domain.Admin;
import com.teamf.voc.repository.AdminRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;


@SpringBootApplication
public class VocApplication {

	@Bean
	Hibernate5Module hibernate5Module(){
		return new Hibernate5Module();
	}

	public static void main(String[] args) {
		SpringApplication.run(VocApplication.class, args);




	}



}
