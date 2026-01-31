package com.example.junit_practice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    private ListManager manager;
    private List<Integer> testList;

    @BeforeEach
    void setUp() {
        manager = new ListManager();
        testList = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        manager.addElement(testList, 42);
        
        assertTrue(testList.contains(42), "List should contain the added element");
        assertEquals(1, testList.size(), "Size should be 1 after adding an element");
    }

    @Test
    void testRemoveElement() {
        manager.addElement(testList, 10);
        manager.addElement(testList, 20);
        
        manager.removeElement(testList, 10);
        
        assertFalse(testList.contains(10), "List should no longer contain 10");
        assertEquals(1, testList.size(), "Size should decrease after removal");
    }

    @Test
    void testGetSize() {
        assertEquals(0, manager.getSize(testList), "Initial size should be 0");
        
        manager.addElement(testList, 5);
        manager.addElement(testList, 15);
        
        assertEquals(2, manager.getSize(testList), "Size should be 2 after two additions");
    }
    
    @Test
    void testNullListHandling() {
        // Ensuring our manager doesn't crash on null inputs
        assertDoesNotThrow(() -> manager.addElement(null, 1));
        assertEquals(0, manager.getSize(null));
    }
}