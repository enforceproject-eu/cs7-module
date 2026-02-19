package org.n52.project.enforce.cs7.api.impl.properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * Cs7ClientAuthorityRepository repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs7ClientAuthorityRepository extends JpaRepository<Cs7ClientAuthority, Integer> {
    
    @Query("select d from Cs7ClientAuthority as d where d.name ilike :name")
    Cs7ClientAuthority findByName(@Param("name") String name);
}
