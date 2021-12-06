package com.teamf.voc;

import com.teamf.voc.domain.Claim;
import com.teamf.voc.domain.Compensation;
import com.teamf.voc.repository.AdminRepository;
import com.teamf.voc.repository.ClaimRepository;
import com.teamf.voc.repository.CompensationRepository;
import com.teamf.voc.service.ClaimService;
import com.teamf.voc.service.CompensationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class VocApplicationTests {

	@Autowired
	EntityManager em;

	@Autowired AdminRepository adminRepository;
	@Autowired ClaimRepository claimRepository;
	@Autowired CompensationRepository compensationRepository;

	@Autowired ClaimService claimService;
	@Autowired CompensationService compensationService;

	@Test
	public void fuck() throws Exception {

		Compensation compensation = new Compensation();

//		Claim a =new Claim();
//		em.persist(a);
//		compensation.setClaim(a);

		compensationRepository.save(compensation);
		compensationService.findCompensations();




	}

}
