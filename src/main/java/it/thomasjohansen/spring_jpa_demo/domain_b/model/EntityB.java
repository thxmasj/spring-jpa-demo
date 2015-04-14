package it.thomasjohansen.spring_jpa_demo.domain_b.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author thomas@thomasjohansen.it
 */
@Entity
public class EntityB {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

}
