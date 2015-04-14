package it.thomasjohansen.spring_jpa_demo.domain_a.service;

import it.thomasjohansen.spring_jpa_demo.domain_a.model.EntityA;
import it.thomasjohansen.spring_jpa_demo.domain_a.repository.EntityARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thomas@thomasjohansen.it
 */
@Service
public class DomainAService {

    @Autowired
    private EntityARepository aRepository;

    public void printAllA() {
        for (EntityA entity : aRepository.findAll())
            System.out.println(entity);
    }

}
