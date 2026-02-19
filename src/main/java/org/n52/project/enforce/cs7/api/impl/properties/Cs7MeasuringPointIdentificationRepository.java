package org.n52.project.enforce.cs7.api.impl.properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * Cs7MeasuringPointIdentificationRepository repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs7MeasuringPointIdentificationRepository extends JpaRepository<Cs7MeasuringPointIdentification, Integer> {
    
    @Query("select d from Cs7MeasuringPointIdentification as d where d.name ilike :name")
    Cs7MeasuringPointIdentification findByName(@Param("name") String name);
}
