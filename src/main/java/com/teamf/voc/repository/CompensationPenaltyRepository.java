package com.teamf.voc.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CompensationPenaltyRepository {

    @PersistenceContext
    private EntityManager em;



}
