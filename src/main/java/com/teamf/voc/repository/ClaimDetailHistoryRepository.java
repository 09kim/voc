package com.teamf.voc.repository;

import com.teamf.voc.domain.ClaimDetailHistory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClaimDetailHistoryRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(ClaimDetailHistory claimDetailHistory) {
        em.persist(claimDetailHistory);
    }

    public List<ClaimDetailHistory> findAll() {
        return em.createQuery("select c from ClaimDetailHistory c", ClaimDetailHistory.class)
                .getResultList();
    }

    public ClaimDetailHistory findOne(Long id) {
        return em.find(ClaimDetailHistory.class, id);
    }


}
