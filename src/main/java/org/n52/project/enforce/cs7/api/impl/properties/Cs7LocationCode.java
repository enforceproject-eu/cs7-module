package org.n52.project.enforce.cs7.api.impl.properties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * <p>
 * Cs7LocationCode DTO.
 * </p>
 *
 * @author Benjamin Pross (b.pross @52north.org)
 * @since 1.0.0
 */
@Entity
@Table(
        name = "cs7_location_code")
public class Cs7LocationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cs7_location_code_generator")
    @SequenceGenerator(name = "cs7_location_code_generator", sequenceName = "cs7_location_code_seq", allocationSize = 1)
    private Integer id;
    
    @Column(
            name = "name")
    private String name;
    
    public Cs7LocationCode() { }

    public Cs7LocationCode(Integer id) {
        this.id = id;
    }

    public Cs7LocationCode(Integer id, String name) {
        this(id);
        this.name = name;
    }
    
    public Cs7LocationCode(String name) {
        this();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + id + ", ");
        sb.append("name" + name + ", ");
        return sb.toString();
    }
}
