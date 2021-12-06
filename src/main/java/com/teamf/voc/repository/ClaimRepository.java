package com.teamf.voc.repository;

import com.teamf.voc.domain.Claim;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClaimRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Claim claim) {
        em.persist(claim);
    }

    public List<Claim> findAll() {
        return em.createQuery("select c from Claim c", Claim.class)
                .getResultList();
    }

    public Claim findOne(Long id) {
        return em.find(Claim.class, id);
    }

    public List<Claim> findByName(String name) {
        return em.createQuery("select c from Claim c where c.name = :name", Claim.class)
                .setParameter("name", name)
                .getResultList();
    }


}
