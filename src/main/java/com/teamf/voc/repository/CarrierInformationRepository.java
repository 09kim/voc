package com.teamf.voc.repository;

import com.teamf.voc.domain.Admin;
import com.teamf.voc.domain.CarrierInformation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CarrierInformationRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(CarrierInformation carrierInformation) {
        em.persist(carrierInformation);
    }

    public CarrierInformation findOne(Long id) {
        return em.find(CarrierInformation.class, id);
    }

    public List<CarrierInformation> findByMobile(String telNo) {
        return em.createQuery("select c from CarrierInformation c where c.tel_no = :telNo", CarrierInformation.class)
                .setParameter("telNo", telNo)
                .getResultList();
    }


}
