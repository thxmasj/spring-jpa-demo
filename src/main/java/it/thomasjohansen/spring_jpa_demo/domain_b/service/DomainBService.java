package it.thomasjohansen.spring_jpa_demo.domain_b.service;

import it.thomasjohansen.spring_jpa_demo.domain_b.model.EntityB;
import it.thomasjohansen.spring_jpa_demo.domain_b.repository.EntityBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thomas@thomasjohansen.it
 */
@Service
public class DomainBService {

    @Autowired
    private EntityBRepository aRepository;

    public void printAllA() {
        for (EntityB entity : aRepository.findAll())
            System.out.println(entity);
    }

}
