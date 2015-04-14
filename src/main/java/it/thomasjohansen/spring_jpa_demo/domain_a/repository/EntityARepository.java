package it.thomasjohansen.spring_jpa_demo.domain_a.repository;

import it.thomasjohansen.spring_jpa_demo.domain_a.model.EntityA;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas@thomasjohansen.it
 */
public interface EntityARepository extends CrudRepository<EntityA, Long> {
}
