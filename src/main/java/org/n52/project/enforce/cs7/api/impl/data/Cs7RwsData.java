package org.n52.project.enforce.cs7.api.impl.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * <p>
 * Data DTO.
 * </p>
 *
 * @author Benjamin Pross (b.pross @52north.org)
 * @since 1.0.0
 */
@Entity
@Table(
        name = "cs7_rws_data")
public class Cs7RwsData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cs7_rws_data_generator")
    @SequenceGenerator(name = "cs7_rws_data_generator", sequenceName = "cs7_rws_data_seq", allocationSize = 1)
    private Integer id;
    
    @Column(
            name = "measuring_point_identification_id")
    private int measuringPointIdentificationId;
    
    @Column(
            name = "location_code_id")
    private int locationCodeId;
    
    @Column(
            name = "magnitude_description_id")
    private int magnitudeDescriptionId;
    
    @Column(
            name = "magnitude_code_id")
    private int magnitudeCodeId;
    
    @Column(
            name = "parameter_description_id")
    private int parameterDescriptionId;
    
    @Column(
            name = "parameter_code_id")
    private int parameterCodeId;
    
    @Column(
            name = "cas_nr_id")
    private int casNrId;
    
    @Column(
            name = "unit_code_id")
    private int unitCodeId;
    
    @Column(
            name = "capacity_description_id")
    private int capacityDescriptionId;
    
    @Column(
            name = "capacity_code_id")
    private int capacityCodeId;
    
    @Column(
            name = "compartment_description_id")
    private int compartmentDescriptionId;
    
    @Column(
            name = "compartment_code_id")
    private int compartmentCodeId;
    
    @Column(
            name = "valuation_method_description_id")
    private int valuationMethodDescriptionId;
    
    @Column(
            name = "valuation_method_code_id")
    private int valuationMethodCodeId;
    
    @Column(
            name = "sampling_type_description_id")
    private int samplingTypeDescriptionId;
    
    @Column(
            name = "sampling_type_code_id")
    private int samplingTypeCodeId;
    
    @Column(
            name = "client_authority_id")
    private int clientAuthorityId;
    
    @Column(
            name = "sampling_device_description_id")
    private int samplingDeviceDescriptionId;
    
    @Column(
            name = "sampling_device_code_id")
    private int samplingDeviceCodeId;
    
    @Column(
            name = "sampling_height")
    private int samplingHeight;
    
    @Column(
            name = "reference_plane_id")
    private int referencePlaneId;   
    
    @Column(
            name = "value")
    private double value;     
    
    @Column(
            name = "date")
    private LocalDateTime date;

    @Column(
            name = "coordinate",
            columnDefinition = "geometry(Point,4326)")
    private Point coordinate;

    public Cs7RwsData() { }

    public Cs7RwsData(LocalDateTime date, Point coordinate) {
        this.date = date;
        this.coordinate = coordinate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMeasuringPointIdentificationId() {
        return measuringPointIdentificationId;
    }

    public void setMeasuringPointIdentificationId(int measuringPointIdentificationId) {
        this.measuringPointIdentificationId = measuringPointIdentificationId;
    }

    public int getLocationCodeId() {
        return locationCodeId;
    }

    public void setLocationCodeId(int locationCodeId) {
        this.locationCodeId = locationCodeId;
    }

    public int getMagnitudeDescriptionId() {
        return magnitudeDescriptionId;
    }

    public void setMagnitudeDescriptionId(int magnitudeDescriptionId) {
        this.magnitudeDescriptionId = magnitudeDescriptionId;
    }

    public int getMagnitudeCodeId() {
        return magnitudeCodeId;
    }

    public void setMagnitudeCodeId(int magnitudeCodeId) {
        this.magnitudeCodeId = magnitudeCodeId;
    }

    public int getParameterDescriptionId() {
        return parameterDescriptionId;
    }

    public void setParameterDescriptionId(int parameterDescriptionId) {
        this.parameterDescriptionId = parameterDescriptionId;
    }

    public int getParameterCodeId() {
        return parameterCodeId;
    }

    public void setParameterCodeId(int parameterCodeId) {
        this.parameterCodeId = parameterCodeId;
    }

    public int getCasNrId() {
        return casNrId;
    }

    public void setCasNrId(int casNrId) {
        this.casNrId = casNrId;
    }

    public int getUnitCodeId() {
        return unitCodeId;
    }

    public void setUnitCodeId(int unitCodeId) {
        this.unitCodeId = unitCodeId;
    }

    public int getCapacityDescriptionId() {
        return capacityDescriptionId;
    }

    public void setCapacityDescriptionId(int capacityDescriptionId) {
        this.capacityDescriptionId = capacityDescriptionId;
    }

    public int getCapacityCodeId() {
        return capacityCodeId;
    }

    public void setCapacityCodeId(int capacityCodeId) {
        this.capacityCodeId = capacityCodeId;
    }

    public int getCompartmentDescriptionId() {
        return compartmentDescriptionId;
    }

    public void setCompartmentDescriptionId(int compartmentDescriptionId) {
        this.compartmentDescriptionId = compartmentDescriptionId;
    }

    public int getCompartmentCodeId() {
        return compartmentCodeId;
    }

    public void setCompartmentCodeId(int compartmentCodeId) {
        this.compartmentCodeId = compartmentCodeId;
    }

    public int getValuationMethodDescriptionId() {
        return valuationMethodDescriptionId;
    }

    public void setValuationMethodDescriptionId(int valuationMethodDescriptionId) {
        this.valuationMethodDescriptionId = valuationMethodDescriptionId;
    }

    public int getValuationMethodCodeId() {
        return valuationMethodCodeId;
    }

    public void setValuationMethodCodeId(int valuationMethodCodeId) {
        this.valuationMethodCodeId = valuationMethodCodeId;
    }

    public int getSamplingTypeDescriptionId() {
        return samplingTypeDescriptionId;
    }

    public void setSamplingTypeDescriptionId(int samplingTypeDescriptionId) {
        this.samplingTypeDescriptionId = samplingTypeDescriptionId;
    }

    public int getSamplingTypeCodeId() {
        return samplingTypeCodeId;
    }

    public void setSamplingTypeCodeId(int samplingTypeCodeId) {
        this.samplingTypeCodeId = samplingTypeCodeId;
    }

    public int getClientAuthorityId() {
        return clientAuthorityId;
    }

    public void setClientAuthorityId(int clientAuthorityId) {
        this.clientAuthorityId = clientAuthorityId;
    }

    public int getSamplingDeviceDescriptionId() {
        return samplingDeviceDescriptionId;
    }

    public void setSamplingDeviceDescriptionId(int samplingDeviceDescriptionId) {
        this.samplingDeviceDescriptionId = samplingDeviceDescriptionId;
    }

    public int getSamplingDeviceCodeId() {
        return samplingDeviceCodeId;
    }

    public void setSamplingDeviceCodeId(int samplingDeviceCodeId) {
        this.samplingDeviceCodeId = samplingDeviceCodeId;
    }

    public int getSamplingHeight() {
        return samplingHeight;
    }

    public void setSamplingHeight(int samplingHeight) {
        this.samplingHeight = samplingHeight;
    }

    public int getReferencePlaneId() {
        return referencePlaneId;
    }

    public void setReferencePlaneId(int referencePlaneId) {
        this.referencePlaneId = referencePlaneId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + id + ", ");
        sb.append("date: " + date + ", ");
        return sb.toString();
    }
}
