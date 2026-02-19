package org.n52.project.enforce.cs7.api.impl.properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * Cs7MagnitudeDescriptionRepository repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs7MagnitudeDescriptionRepository extends JpaRepository<Cs7MagnitudeDescription, Integer> {
    
    @Query("select d from Cs7MagnitudeDescription as d where d.name ilike :name")
    Cs7MagnitudeDescription findByName(@Param("name") String name);
}
