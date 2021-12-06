package com.teamf.voc.repository;

import com.teamf.voc.domain.DeliveryWorkerIncentive;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DeliveryWorkerIncentiveRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(DeliveryWorkerIncentive deliveryWorkerIncentive) {
        em.persist(deliveryWorkerIncentive);
    }

    public List<DeliveryWorkerIncentive> findAll() {
        return em.createQuery("select d from DeliveryWorkerIncentive d", DeliveryWorkerIncentive.class)
                .getResultList();
    }

    public DeliveryWorkerIncentive findOne(Long id) {
        return em.find(DeliveryWorkerIncentive.class, id);
    }

}
