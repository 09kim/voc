package com.teamf.voc.repository;

import com.teamf.voc.domain.Compensation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompensationRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Compensation compensation) {
        em.persist(compensation);
    }

    public List<Compensation> findAll() {
        return em.createQuery("select c from Compensation c", Compensation.class)
                .getResultList();
    }

    public Compensation findOne(Long id) {
        return em.find(Compensation.class, id);
    }

    public List<Compensation> findCompensationList() {
        return em.createQuery(
                        "select c from Compensation c" +
                                " join fetch c.claim cl", Compensation.class)
                                  .getResultList();
    }


}
