package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CDProductTest {
    
    CDProduct cd;
    
    @BeforeEach
    void setUp() {
         cd = new CDProduct("Metallica", 10, 18);
    }
    
    @AfterEach
    void tearDown() {
    }
    
    @Test
    void getSize() {
        assertEquals(18, cd.getSize());
    }
    
    
}