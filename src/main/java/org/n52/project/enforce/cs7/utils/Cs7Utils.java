package org.n52.project.enforce.cs7.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.n52.project.enforce.cs7.api.impl.data.Cs7RwsData;
import org.n52.project.enforce.cs7.api.impl.data.Cs7RwsDataRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CapacityCode;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CapacityCodeRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CapacityDescription;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CapacityDescriptionRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CasNr;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CasNrRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ClientAuthority;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ClientAuthorityRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CompartmentCode;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CompartmentCodeRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CompartmentDescription;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7CompartmentDescriptionRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7LocationCode;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7LocationCodeRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7MagnitudeCode;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7MagnitudeCodeRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7MagnitudeDescription;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7MagnitudeDescriptionRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7MeasuringPointIdentification;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7MeasuringPointIdentificationRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ParameterCode;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ParameterCodeRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ParameterDescription;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ParameterDescriptionRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ReferencePlane;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ReferencePlaneRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7SamplingDeviceDescription;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7SamplingDeviceDescriptionRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7SamplingTypeCode;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7SamplingTypeCodeRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7SamplingTypeDescription;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7SamplingTypeDescriptionRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7UnitCode;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7UnitCodeRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ValuationMethodCode;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ValuationMethodCodeRepository;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ValuationMethodDescription;
import org.n52.project.enforce.cs7.api.impl.properties.Cs7ValuationMethodDescriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Cs7Utils {

    private static final String COMMA_DELIMITER = ";";

    private Cs7RwsDataRepository cs7DataRepository;

    private Cs7ReferencePlaneRepository cs7ReferencePlaneRepository;
    
    private Cs7SamplingDeviceDescriptionRepository cs7SamplingDeviceDescriptionRepository;

    private Cs7ClientAuthorityRepository cs7ClientAuthorityRepository;

    private Cs7SamplingTypeCodeRepository cs7SamplingTypeCodeRepository;

    private Cs7SamplingTypeDescriptionRepository cs7SamplingTypeDescriptionRepository;

    private Cs7ValuationMethodCodeRepository cs7ValuationMethodCodeRepository;

    private Cs7ValuationMethodDescriptionRepository cs7ValuationMethodDescriptionRepository;

    private Cs7CompartmentCodeRepository cs7CompartmentCodeRepository;

    private Cs7CompartmentDescriptionRepository cs7CompartmentDescriptionRepository;

    private Cs7CapacityCodeRepository cs7CapacityCodeRepository;

    private Cs7CapacityDescriptionRepository cs7CapacityDescriptionRepository;

    private Cs7UnitCodeRepository cs7UnitCodeRepository;

    private Cs7CasNrRepository cs7CasNrRepository;

    private Cs7ParameterCodeRepository cs7ParameterCodeRepository;

    private Cs7ParameterDescriptionRepository cs7ParameterDescriptionRepository;

    private Cs7MagnitudeCodeRepository cs7MagnitudeCodeRepository;

    private Cs7MagnitudeDescriptionRepository cs7MagnitudeDescriptionRepository;

    private Cs7LocationCodeRepository cs7LocationCodeRepository;

    private Cs7MeasuringPointIdentificationRepository cs7MeasuringPointIdentificationRepository;
        
    private DateTimeFormatter dateTimeFormatter;

    GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 25831);

    ObjectMapper objectMapper = new ObjectMapper();

    private static Logger LOG = LoggerFactory.getLogger(Cs7Utils.class);

    public Cs7Utils(Cs7RwsDataRepository cs8DataRepository, Cs7ReferencePlaneRepository cs7ReferencePlaneRepository,
            Cs7SamplingDeviceDescriptionRepository cs7SamplingDeviceDescriptionRepository,
            Cs7ClientAuthorityRepository cs7ClientAuthorityRepository,
            Cs7SamplingTypeCodeRepository cs7SamplingTypeCodeRepository,
            Cs7SamplingTypeDescriptionRepository cs7SamplingTypeDescriptionRepository,
            Cs7ValuationMethodCodeRepository cs7ValuationMethodCodeRepository,
            Cs7ValuationMethodDescriptionRepository cs7ValuationMethodDescriptionRepository,
            Cs7CompartmentCodeRepository cs7CompartmentCodeRepository,
            Cs7CompartmentDescriptionRepository cs7CompartmentDescriptionRepository,
            Cs7CapacityCodeRepository cs7CapacityCodeRepository,
            Cs7CapacityDescriptionRepository cs7CapacityDescriptionRepository,
            Cs7UnitCodeRepository cs7UnitCodeRepository, Cs7CasNrRepository cs7CasNrRepository,
            Cs7ParameterCodeRepository cs7ParameterCodeRepository,
            Cs7ParameterDescriptionRepository cs7ParameterDescriptionRepository,
            Cs7MagnitudeCodeRepository cs7MagnitudeCodeRepository,
            Cs7MagnitudeDescriptionRepository cs7MagnitudeDescriptionRepository,
            Cs7LocationCodeRepository cs7LocationCodeRepository,
            Cs7MeasuringPointIdentificationRepository cs7MeasuringPointIdentificationRepository) {
        this.cs7DataRepository = cs8DataRepository;
        this.cs7ReferencePlaneRepository = cs7ReferencePlaneRepository;
        this.cs7SamplingDeviceDescriptionRepository = cs7SamplingDeviceDescriptionRepository;
        this.cs7ClientAuthorityRepository = cs7ClientAuthorityRepository;
        this.cs7SamplingTypeCodeRepository = cs7SamplingTypeCodeRepository;
        this.cs7SamplingTypeDescriptionRepository = cs7SamplingTypeDescriptionRepository;
        this.cs7ValuationMethodCodeRepository = cs7ValuationMethodCodeRepository;
        this.cs7ValuationMethodDescriptionRepository = cs7ValuationMethodDescriptionRepository;
        this.cs7CompartmentCodeRepository = cs7CompartmentCodeRepository;
        this.cs7CompartmentDescriptionRepository = cs7CompartmentDescriptionRepository;
        this.cs7CapacityCodeRepository = cs7CapacityCodeRepository;
        this.cs7CapacityDescriptionRepository = cs7CapacityDescriptionRepository;
        this.cs7UnitCodeRepository = cs7UnitCodeRepository;
        this.cs7CasNrRepository = cs7CasNrRepository;
        this.cs7ParameterCodeRepository = cs7ParameterCodeRepository;
        this.cs7ParameterDescriptionRepository = cs7ParameterDescriptionRepository;
        this.cs7MagnitudeCodeRepository = cs7MagnitudeCodeRepository;
        this.cs7MagnitudeDescriptionRepository = cs7MagnitudeDescriptionRepository;
        this.cs7LocationCodeRepository = cs7LocationCodeRepository;
        this.cs7MeasuringPointIdentificationRepository = cs7MeasuringPointIdentificationRepository;
        dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss", Locale.ENGLISH);
    }

    public void readCsvFile(InputStream inputstream) throws IOException {
        File tmpExcelFile = File.createTempFile("excel", ".csv");
        IOUtils.copy(inputstream, new FileOutputStream(tmpExcelFile));
        readCsvFile(tmpExcelFile);
    }

    public void readCsvFile(File csvFile) throws IOException {
        try (Scanner scanner = new Scanner(csvFile)) {
            //skip header
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] row = scanner.nextLine().split(COMMA_DELIMITER);
                Cs7RwsData data = new Cs7RwsData();
                for (int k = 0; k < 50; k++) {
                    
                    switch (k) {
                    case 0:
                        //first column seems to be empty
                        break;
                    case 1:
                        String measuringPointIdentificationName = row[k];
                        if (measuringPointIdentificationName == null || measuringPointIdentificationName.isBlank()) {
                            data.setMeasuringPointIdentificationId(1);
                            break;
                        }
                        Cs7MeasuringPointIdentification measuringPointIdentification =
                                cs7MeasuringPointIdentificationRepository.findByName(measuringPointIdentificationName);
                        int measuringPointIdentificationId = 1;
                        if (measuringPointIdentification == null) {
                            measuringPointIdentification = new Cs7MeasuringPointIdentification(measuringPointIdentificationName);
                            cs7MeasuringPointIdentificationRepository.saveAndFlush(measuringPointIdentification);
                        } 
                        measuringPointIdentificationId = measuringPointIdentification.getId();
                        data.setMeasuringPointIdentificationId(measuringPointIdentificationId);
                        break;
                    case 2:
                        String locationCodeName = row[k];
                        if (locationCodeName == null || locationCodeName.isBlank()) {
                            data.setLocationCodeId(1);
                            break;
                        }
                        Cs7LocationCode locationCode =
                                cs7LocationCodeRepository.findByName(locationCodeName);
                        int locationCodeId = 1;
                        if (locationCode == null) {
                            locationCode = new Cs7LocationCode(locationCodeName);
                            cs7LocationCodeRepository.saveAndFlush(locationCode);
                        } 
                        locationCodeId = locationCode.getId();
                        data.setLocationCodeId(locationCodeId);
                        break;
                    case 5:
                        String magnitudeDescriptionName = row[k];
                        if (magnitudeDescriptionName == null || magnitudeDescriptionName.isBlank()) {
                            data.setMagnitudeDescriptionId(1);
                            break;
                        }
                        Cs7MagnitudeDescription magnitudeDescription =
                                cs7MagnitudeDescriptionRepository.findByName(magnitudeDescriptionName);
                        int magnitudeDescriptionId = 1;
                        if (magnitudeDescription == null) {
                            magnitudeDescription = new Cs7MagnitudeDescription(magnitudeDescriptionName);
                            cs7MagnitudeDescriptionRepository.saveAndFlush(magnitudeDescription);
                        } 
                        magnitudeDescriptionId = magnitudeDescription.getId();
                        data.setMagnitudeDescriptionId(magnitudeDescriptionId);
                        break;
                    case 6:
                        String magnitudeCodeName = row[k];
                        if (magnitudeCodeName == null || magnitudeCodeName.isBlank()) {
                            data.setMagnitudeCodeId(1);
                            break;
                        }
                        Cs7MagnitudeCode magnitudeCode =
                                cs7MagnitudeCodeRepository.findByName(magnitudeCodeName);
                        int magnitudeCodeId = 1;
                        if (magnitudeCode == null) {
                            magnitudeCode = new Cs7MagnitudeCode(magnitudeCodeName);
                            cs7MagnitudeCodeRepository.saveAndFlush(magnitudeCode);
                        } 
                        magnitudeCodeId = magnitudeCode.getId();
                        data.setMagnitudeCodeId(magnitudeCodeId);
                        break;
                    case 7:
                        String parameterDescriptionName = row[k];
                        if (parameterDescriptionName == null || parameterDescriptionName.isBlank()) {
                            data.setParameterDescriptionId(1);
                            break;
                        }
                        Cs7ParameterDescription parameterDescription =
                                cs7ParameterDescriptionRepository.findByName(parameterDescriptionName);
                        int parameterDescriptionId = 1;
                        if (parameterDescription == null) {
                            parameterDescription = new Cs7ParameterDescription(parameterDescriptionName);
                            cs7ParameterDescriptionRepository.saveAndFlush(parameterDescription);
                        } 
                        parameterDescriptionId = parameterDescription.getId();
                        data.setParameterDescriptionId(parameterDescriptionId);
                        break;
                    case 8:
                        String parameterCodeName = row[k];
                        if (parameterCodeName == null || parameterCodeName.isBlank()) {
                            data.setParameterCodeId(1);
                            break;
                        }
                        Cs7ParameterCode parameterCode =
                                cs7ParameterCodeRepository.findByName(parameterCodeName);
                        int parameterCodeId = 1;
                        if (parameterCode == null) {
                            parameterCode = new Cs7ParameterCode(parameterCodeName);
                            cs7ParameterCodeRepository.saveAndFlush(parameterCode);
                        } 
                        parameterCodeId = parameterCode.getId();
                        data.setParameterCodeId(parameterCodeId);
                        break;
                    case 9:
                        String casNrName = row[k];
                        if (casNrName == null || casNrName.isBlank()) {
                            data.setCasNrId(1);
                            break;
                        }
                        Cs7CasNr casNr =
                                cs7CasNrRepository.findByName(casNrName);
                        int casNrId = 1;
                        if (casNr == null) {
                            casNr = new Cs7CasNr(casNrName);
                            cs7CasNrRepository.saveAndFlush(casNr);
                        } 
                        casNrId = casNr.getId();
                        data.setCasNrId(casNrId);
                        break;
                    case 10:
                        String unitCodeName = row[k];
                        if (unitCodeName == null || unitCodeName.isBlank()) {
                            data.setUnitCodeId(1);
                            break;
                        }
                        Cs7UnitCode unitCode =
                                cs7UnitCodeRepository.findByName(unitCodeName);
                        int unitCodeId = 1;
                        if (unitCode == null) {
                            unitCode = new Cs7UnitCode(unitCodeName);
                            cs7UnitCodeRepository.saveAndFlush(unitCode);
                        } 
                        unitCodeId = unitCode.getId();
                        data.setUnitCodeId(unitCodeId);
                        break;
                    case 11:
                        String capacityDescriptionName = row[k];
                        if (capacityDescriptionName == null || capacityDescriptionName.isBlank()) {
                            data.setCapacityDescriptionId(1);
                            break;
                        }
                        Cs7CapacityDescription capacityDescription =
                                cs7CapacityDescriptionRepository.findByName(capacityDescriptionName);
                        int capacityDescriptionId = 1;
                        if (capacityDescription == null) {
                            capacityDescription = new Cs7CapacityDescription(capacityDescriptionName);
                            cs7CapacityDescriptionRepository.saveAndFlush(capacityDescription);
                        } 
                        capacityDescriptionId = capacityDescription.getId();
                        data.setCapacityDescriptionId(capacityDescriptionId);
                        break;
                    case 12:
                        String capacityCodeName = row[k];
                        if (capacityCodeName == null || capacityCodeName.isBlank()) {
                            data.setCapacityCodeId(1);
                            break;
                        }
                        Cs7CapacityCode capacityCode =
                                cs7CapacityCodeRepository.findByName(capacityCodeName);
                        int capacityCodeId = 1;
                        if (capacityCode == null) {
                            capacityCode = new Cs7CapacityCode(capacityCodeName);
                            cs7CapacityCodeRepository.saveAndFlush(capacityCode);
                        } 
                        capacityCodeId = capacityCode.getId();
                        data.setCapacityCodeId(capacityCodeId);
                        break;
                    case 13:
                        String compartmentDescriptionName = row[k];
                        if (compartmentDescriptionName == null || compartmentDescriptionName.isBlank()) {
                            data.setCompartmentDescriptionId(1);
                            break;
                        }
                        Cs7CompartmentDescription compartmentDescription =
                                cs7CompartmentDescriptionRepository.findByName(compartmentDescriptionName);
                        int compartmentDescriptionId = 1;
                        if (compartmentDescription == null) {
                            compartmentDescription = new Cs7CompartmentDescription(compartmentDescriptionName);
                            cs7CompartmentDescriptionRepository.saveAndFlush(compartmentDescription);
                        } 
                        compartmentDescriptionId = compartmentDescription.getId();
                        data.setCompartmentDescriptionId(compartmentDescriptionId);
                        break;
                    case 14:
                        String compartmentCodeName = row[k];
                        if (compartmentCodeName == null || compartmentCodeName.isBlank()) {
                            data.setCompartmentCodeId(1);
                            break;
                        }
                        Cs7CompartmentCode compartmentCode =
                                cs7CompartmentCodeRepository.findByName(compartmentCodeName);
                        int compartmentCodeId = 1;
                        if (compartmentCode == null) {
                            compartmentCode = new Cs7CompartmentCode(compartmentCodeName);
                            cs7CompartmentCodeRepository.saveAndFlush(compartmentCode);
                        } 
                        compartmentCodeId = compartmentCode.getId();
                        data.setCompartmentCodeId(compartmentCodeId);
                        break;
                    case 17:
                        String valuationMethodDescriptionName = row[k];
                        if (valuationMethodDescriptionName == null || valuationMethodDescriptionName.isBlank()) {
                            data.setValuationMethodDescriptionId(1);
                            break;
                        }
                        Cs7ValuationMethodDescription valuationMethodDescription =
                                cs7ValuationMethodDescriptionRepository.findByName(valuationMethodDescriptionName);
                        int valuationMethodDescriptionId = 1;
                        if (valuationMethodDescription == null) {
                            valuationMethodDescription = new Cs7ValuationMethodDescription(valuationMethodDescriptionName);
                            cs7ValuationMethodDescriptionRepository.saveAndFlush(valuationMethodDescription);
                        } 
                        valuationMethodDescriptionId = valuationMethodDescription.getId();
                        data.setValuationMethodDescriptionId(valuationMethodDescriptionId);
                        break;
                    case 18:
                        String valuationMethodCodeName = row[k];
                        if (valuationMethodCodeName == null || valuationMethodCodeName.isBlank()) {
                            data.setValuationMethodCodeId(1);
                            break;
                        }
                        Cs7ValuationMethodCode valuationMethodCode =
                                cs7ValuationMethodCodeRepository.findByName(valuationMethodCodeName);
                        int valuationMethodCodeId = 1;
                        if (valuationMethodCode == null) {
                            valuationMethodCode = new Cs7ValuationMethodCode(valuationMethodCodeName);
                            cs7ValuationMethodCodeRepository.saveAndFlush(valuationMethodCode);
                        } 
                        valuationMethodCodeId = valuationMethodCode.getId();
                        data.setValuationMethodCodeId(valuationMethodCodeId);
                        break;
                    case 19:
                        String samplingTypeDescriptionName = row[k];
                        if (samplingTypeDescriptionName == null || samplingTypeDescriptionName.isBlank()) {
                            data.setSamplingTypeDescriptionId(1);
                            break;
                        }
                        Cs7SamplingTypeDescription samplingTypeDescription =
                                cs7SamplingTypeDescriptionRepository.findByName(samplingTypeDescriptionName);
                        int samplingTypeDescriptionId = 1;
                        if (samplingTypeDescription == null) {
                            samplingTypeDescription = new Cs7SamplingTypeDescription(samplingTypeDescriptionName);
                            cs7SamplingTypeDescriptionRepository.saveAndFlush(samplingTypeDescription);
                        } 
                        samplingTypeDescriptionId = samplingTypeDescription.getId();
                        data.setSamplingTypeDescriptionId(samplingTypeDescriptionId);
                        break;
                    case 20:
                        String samplingTypeCodeName = row[k];
                        if (samplingTypeCodeName == null || samplingTypeCodeName.isBlank()) {
                            data.setSamplingTypeCodeId(1);
                            break;
                        }
                        Cs7SamplingTypeCode samplingTypeCode =
                                cs7SamplingTypeCodeRepository.findByName(samplingTypeCodeName);
                        int samplingTypeCodeId = 1;
                        if (samplingTypeCode == null) {
                            samplingTypeCode = new Cs7SamplingTypeCode(samplingTypeCodeName);
                            cs7SamplingTypeCodeRepository.saveAndFlush(samplingTypeCode);
                        } 
                        samplingTypeCodeId = samplingTypeCode.getId();
                        data.setSamplingTypeCodeId(samplingTypeCodeId);
                        break;
                    case 21:
                        //get values for 21 and 22 and create date
                        String dateString = row[k];
                        String timeString = row[k+1];
                        try {
                            data.setDate(LocalDateTime.from(dateTimeFormatter.parse(dateString + "T" + timeString)));
                        } catch (Exception e) {
                            LOG.error(String.format("Could not parse date %s and time %s", dateString, timeString));
                        }
                        break;
                    case 24:
                        String value = row[k].replace(",", ".");
                        try {
                            data.setValue(Double.parseDouble(value));
                        } catch (Exception e) {
                            LOG.warn("Could not parse value: " + value);
                            data.setValue(Double.NaN);
                        }
                        break;
                    case 31:
                        String clientAuthorityName = row[k];
                        if (clientAuthorityName == null || clientAuthorityName.isBlank()) {
                            data.setClientAuthorityId(1);
                            break;
                        }
                        Cs7ClientAuthority clientAuthority =
                                cs7ClientAuthorityRepository.findByName(clientAuthorityName);
                        int clientAuthorityId = 1;
                        if (clientAuthority == null) {
                            clientAuthority = new Cs7ClientAuthority(clientAuthorityName);
                            cs7ClientAuthorityRepository.saveAndFlush(clientAuthority);
                        } 
                        clientAuthorityId = clientAuthority.getId();
                        data.setClientAuthorityId(clientAuthorityId);
                        break;
                    case 34:
                        String samplingDeviceDescriptionName = row[k];
                        if (samplingDeviceDescriptionName == null || samplingDeviceDescriptionName.isBlank()) {
                            data.setSamplingDeviceDescriptionId(1);
                            break;
                        }
                        Cs7SamplingDeviceDescription samplingDeviceDescription =
                                cs7SamplingDeviceDescriptionRepository.findByName(samplingDeviceDescriptionName);
                        int samplingDeviceDescriptionId = 1;
                        if (samplingDeviceDescription == null) {
                            samplingDeviceDescription = new Cs7SamplingDeviceDescription(samplingDeviceDescriptionName);
                            cs7SamplingDeviceDescriptionRepository.saveAndFlush(samplingDeviceDescription);
                        } 
                        samplingDeviceDescriptionId = samplingDeviceDescription.getId();
                        data.setSamplingDeviceDescriptionId(samplingDeviceDescriptionId);
                        break;
                    case 38:
                        String samplingHeight = row[k];
                        if (samplingHeight == null || samplingHeight.isBlank()) {
                            data.setSamplingHeight(-1);
                        } else {
                            data.setSamplingHeight(Integer.parseInt(samplingHeight));
                        }
                        break;
                    case 39:
                        String referencePlaneName = row[k];
                        if (referencePlaneName == null || referencePlaneName.isBlank()) {
                            data.setReferencePlaneId(1);
                            break;
                        }
                        Cs7ReferencePlane referencePlane =
                                cs7ReferencePlaneRepository.findByName(referencePlaneName);
                        int referencePlaneId = 1;
                        if (referencePlane == null) {
                            referencePlane = new Cs7ReferencePlane(referencePlaneName);
                            cs7ReferencePlaneRepository.saveAndFlush(referencePlane);
                        } 
                        referencePlaneId = referencePlane.getId();
                        data.setReferencePlaneId(referencePlaneId);
                        break;
                    case 41:
                        //get 49 and 50
                        String x = row[k].replace(",", ".");
                        String y = row[k+1].replace(",", ".");
                        data.setCoordinate(createPoint(x + "," + y));
                        break;
                    default:
                        continue;
                    }
                }
                data = cs7DataRepository.saveAndFlush(data);
                LOG.info(String.format("Data with id %d added to cs7 rws data.", data.getId()));
            }
        }
    }

    private Point createPoint(String pointAsString) {
        if (pointAsString != null) {
            String[] coordinateArray = pointAsString.split(",");
            if (coordinateArray.length == 2) {
                String latStrg = coordinateArray[0];
                String lngStrg = coordinateArray[1];
                if ((latStrg != null && !latStrg.isEmpty()) && (lngStrg != null && !lngStrg.isEmpty())) {
                    double lat = Double.parseDouble(latStrg);
                    double lng = Double.parseDouble(lngStrg);
                    return geometryFactory.createPoint(new Coordinate(lat, lng));
                }
            }
        }
        return geometryFactory.createPoint(new Coordinate(0, 0));
    }

}
