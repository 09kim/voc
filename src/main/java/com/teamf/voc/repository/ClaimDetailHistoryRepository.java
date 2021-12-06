package com.teamf.voc.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClaimDetailHistoryRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(ClaimDetailHistoryRepository claimDetailHistory) {
        em.persist(claimDetailHistory);
    }


}
