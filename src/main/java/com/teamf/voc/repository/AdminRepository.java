package com.teamf.voc.repository;

import com.teamf.voc.domain.Admin;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AdminRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Admin admin) {
        em.persist(admin);
    }

    public Admin findOne(Long id) {
        return em.find(Admin.class, id);
    }

    public List<Admin> findByName(String name) {
        return em.createQuery("select a from Admin a where a.name = :name", Admin.class)
                .setParameter("name", name)
                .getResultList();
    }


}
