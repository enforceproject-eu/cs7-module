package org.n52.project.enforce.cs7.api.impl.properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * Cs7CompartmentDescriptionRepository repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs7CompartmentDescriptionRepository extends JpaRepository<Cs7CompartmentDescription, Integer> {
    
    @Query("select d from Cs7CompartmentDescription as d where d.name ilike :name")
    Cs7CompartmentDescription findByName(@Param("name") String name);
}
