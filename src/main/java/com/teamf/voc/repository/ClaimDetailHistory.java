package com.teamf.voc.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClaimDetailHistory {

    @PersistenceContext
    private EntityManager em;

    public void save(ClaimDetailHistory claimDetailHistory) {
        em.persist(claimDetailHistory);
    }


}
