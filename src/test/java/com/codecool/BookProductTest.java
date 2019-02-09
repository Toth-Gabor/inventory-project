package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookProductTest {
    
    BookProduct book;
    
    @BeforeEach
    void setUp() {
        book = new BookProduct("Maugli", 11, 300);
        
    }
    
    @Test
    void getSize() {
        assertEquals(300, book.getSize());
    }
}