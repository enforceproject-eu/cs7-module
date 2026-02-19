package org.n52.project.enforce.cs7.api.impl.properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * Cs7MagnitudeCodeRepository repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs7MagnitudeCodeRepository extends JpaRepository<Cs7MagnitudeCode, Integer> {
    
    @Query("select d from Cs7MagnitudeCode as d where d.name ilike :name")
    Cs7MagnitudeCode findByName(@Param("name") String name);
}
