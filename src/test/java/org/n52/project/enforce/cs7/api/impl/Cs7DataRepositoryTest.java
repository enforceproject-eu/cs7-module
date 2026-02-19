package org.n52.project.enforce.cs7.api.impl;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.n52.project.enforce.cs7.api.impl.data.Cs7RwsData;
import org.n52.project.enforce.cs7.api.impl.data.Cs7RwsDataRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7MeasuringPointIdentification;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7MeasuringPointIdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Cs7DataRepositoryTest extends DBTest {

    @Autowired
    Cs7RwsDataRepository cs7DataRepository;
    
    @Autowired
    Cs7MeasuringPointIdentificationRepository cs7MeasuringPointIdentificationRepository;
    
    GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
    
    Random random = new Random();
    
    @Test
    void testCreateData() {
        
        Cs7MeasuringPointIdentification cs7MeasuringPointIdentification = new Cs7MeasuringPointIdentification("test", "test_eng");        
        cs7MeasuringPointIdentificationRepository.saveAndFlush(cs7MeasuringPointIdentification);        
        double x = Double.parseDouble("567471.288352853");
        double y = Double.parseDouble("6030175.29747803");
        Cs7RwsData csData = new Cs7RwsData();
        csData.setMeasuringPointIdentificationId(1);
        csData.setCapacityCodeId(1);
        csData.setCapacityDescriptionId(1);
        csData.setCasNrId(1);
        csData.setClientAuthorityId(1);
        csData.setCompartmentCodeId(1);
        csData.setCompartmentDescriptionId(1);
        csData.setLocationCodeId(1);
        csData.setMagnitudeCodeId(1);
        csData.setMagnitudeDescriptionId(1);
        csData.setParameterCodeId(1);
        csData.setParameterDescriptionId(1);
        csData.setReferencePlaneId(1);
        csData.setSamplingDeviceCodeId(1);
        csData.setSamplingHeight(-100);
        csData.setSamplingDeviceDescriptionId(1);
        csData.setSamplingTypeCodeId(1);
        csData.setSamplingTypeDescriptionId(1);
        csData.setUnitCodeId(1);
        csData.setValuationMethodCodeId(1);
        csData.setValuationMethodDescriptionId(1);
        csData.setCoordinate(new GeometryFactory(new PrecisionModel(), 25831).createPoint(new Coordinate(x, y)));
        cs7DataRepository.saveAndFlush(csData);
          
        
    }
    
}
