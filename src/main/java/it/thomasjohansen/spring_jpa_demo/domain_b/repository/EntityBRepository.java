package it.thomasjohansen.spring_jpa_demo.domain_b.repository;

import it.thomasjohansen.spring_jpa_demo.domain_b.model.EntityB;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas@thomasjohansen.it
 */
public interface EntityBRepository extends CrudRepository<EntityB, Long> {
}
