package com.teamf.voc.repository;


import com.teamf.voc.domain.ClaimDetail;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClaimDetailRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(ClaimDetail claimDetail) {
        em.persist(claimDetail);
    }

    public ClaimDetail findOne(Long id) {
        return em.find(ClaimDetail.class, id);
    }






}
