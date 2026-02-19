package org.n52.project.enforce.cs7.api.impl;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.n52.project.enforce.cs7.utils.Cs7Utils;
import org.springframework.beans.factory.annotation.Autowired;

public class Cs7UtilsTest extends DBTest{
    
    @Autowired
    Cs7Utils cs7Utils;
        
    @Test
    void testReadExcelFile() {
        try {
            cs7Utils.readCsvFile(getClass().getResourceAsStream("sample.csv"));
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
