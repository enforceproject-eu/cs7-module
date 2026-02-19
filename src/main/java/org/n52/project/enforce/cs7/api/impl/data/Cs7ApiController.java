package org.n52.project.enforce.cs7.api.impl.data;

import java.io.IOException;

import org.n52.project.enforce.cs7.api.Cs7Api;
import org.n52.project.enforce.cs7.utils.Cs7Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-08T13:43:38.513185600+01:00[Europe/Berlin]", comments = "Generator version: 7.13.0")
@Controller
@RequestMapping("${openapi.eNFORCECS5DataAccess.base-path:}")
public class Cs7ApiController implements Cs7Api {

    Cs7Utils cs7Utils;

    Cs7RwsDataRepository cs7DataRepository;
    

    @Autowired
    public Cs7ApiController(Cs7Utils cs7Utils, Cs7RwsDataRepository cs5DataRepository) {
        this.cs7Utils = cs7Utils;
        this.cs7DataRepository = cs5DataRepository;
    }

    @Override
    public ResponseEntity<?> addCs7DataAsBody(@Valid Resource requestBody) {
        try {
            cs7Utils.readCsvFile(requestBody.getInputStream());
        } catch (IOException e) {
           return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getCs7Data() {
        return ResponseEntity.ok().body(cs7DataRepository.getGeoJson());
    }
}
