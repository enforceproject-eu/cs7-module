package org.n52.project.enforce.cs7.api.impl.properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * Cs7UnitCodeRepository repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs7UnitCodeRepository extends JpaRepository<Cs7UnitCode, Integer> {
    
    @Query("select d from Cs7UnitCode as d where d.name ilike :name")
    Cs7UnitCode findByName(@Param("name") String name);
}
