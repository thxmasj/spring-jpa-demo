package it.thomasjohansen.spring_jpa_demo.domain_a.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author thomas@thomasjohansen.it
 */
@Entity
public class EntityA {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

}
