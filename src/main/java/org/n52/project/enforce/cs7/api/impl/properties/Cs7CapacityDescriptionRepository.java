package org.n52.project.enforce.cs7.api.impl.properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * Cs7CapacityDescriptionRepository repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs7CapacityDescriptionRepository extends JpaRepository<Cs7CapacityDescription, Integer> {
    
    @Query("select d from Cs7CapacityDescription as d where d.name ilike :name")
    Cs7CapacityDescription findByName(@Param("name") String name);
}
