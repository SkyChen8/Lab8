package com.example.lab8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Test checking if a city exists in the list.
     * Add a city and verify it exists, then check for a city that doesn't exist.
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        City nonExistentCity = new City("Regina", "SK");

        assertFalse(list.hasCity(nonExistentCity));  // Check for a city that doesn't exist
        list.addCity(city);
        assertTrue(list.hasCity(city));  // Ensure the added city is found
        assertFalse(list.hasCity(nonExistentCity));  // Ensure the non-existent city is still not found
    }

    /**
     * Test the deletion of a city from the list.
     * First, add a city and ensure it is added.
     * Then, delete the city and check if it is removed.
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(1, list.getCount());  // Ensure the city is added

        list.deleteCity(city);
        assertEquals(0, list.getCount());  // Ensure the city is deleted
    }

    @Test
    public void countCityTest() {
        list = MockCityList();
        assertEquals(0, list.countCities());  // Initially, the list should be empty

        City city1 = new City("Estevan", "SK");
        City city2 = new City("Regina", "SK");

        list.addCity(city1);
        assertEquals(1, list.countCities());  // After adding one city, count should be 1

        list.addCity(city2);
        assertEquals(2, list.countCities());  // After adding a second city, count should be 2

        list.deleteCity(city1);
        assertEquals(1, list.countCities());  // After deleting one city, count should decrease to 1
    }
}



