package com.teamf.voc.repository;

import com.teamf.voc.domain.Claim;
import com.teamf.voc.domain.enums.BoolCheck;
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

    public Claim findObjection() {
        return em.createQuery("select c from Claim c where c.is_crr_objection = :boolCheck", Claim.class)
                .setParameter("boolCheck", BoolCheck.Y)
                .getSingleResult();
    }


    public List<Claim> findVocList() {
        return em.createQuery(
                "select c from Claim c" +
                        " join fetch c.compensation co" +
                        " join fetch c.claimDetail cd" +
                        " join fetch co.compensationPenalty cp", Claim.class)
                .getResultList();
    }


}
