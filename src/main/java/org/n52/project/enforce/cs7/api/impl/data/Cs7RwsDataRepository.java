package org.n52.project.enforce.cs7.api.impl.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>
 * Data repository.
 * </p>
 *
 * @author Benjamin Pross 
 * @since 1.0.0
 */
public interface Cs7RwsDataRepository extends JpaRepository<Cs7RwsData, Integer> {
    
    /**
     * <p>
     * getGeoJson.
     * </p>
     * 
     * @return a {@link String} object
     */
    @Query("select ST_Cs7RwsDataToGeoJson()")
    String getGeoJson();
}
