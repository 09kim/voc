package com.teamf.voc.repository;


import com.teamf.voc.domain.ClaimDetail;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClaimDetailRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(ClaimDetail claimDetail) {
        em.persist(claimDetail);
    }

    public List<ClaimDetail> findAll() {
        return em.createQuery("select d from ClaimDetail d", ClaimDetail.class)
                .getResultList();
    }

    public ClaimDetail findOne(Long id) {
        return em.find(ClaimDetail.class, id);
    }

}
