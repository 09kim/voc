package com.teamf.voc.repository;

import com.teamf.voc.domain.CompensationPenalty;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompensationPenaltyRepository {


    @PersistenceContext
    private EntityManager em;

    public void save(CompensationPenalty compensationPenalty) {
        em.persist(compensationPenalty);
    }

    public List<CompensationPenalty> findAll() {
        return em.createQuery("select c from CompensationPenalty c", CompensationPenalty.class)
                .getResultList();
    }

    public CompensationPenalty findOne(Long id) {
        return em.find(CompensationPenalty.class, id);
    }


}
