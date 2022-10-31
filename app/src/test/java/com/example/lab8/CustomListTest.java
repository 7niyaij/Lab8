package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * check if the list has a city
     * add a city to list
     * check if the city is inside the list matches true
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(list.hasCity(city), true);
    }

    /**
     * add a city to list
     * check if the city is inside the list
     * check the size of the list
     * delete the city from list
     * check if the city is inside the list
     * check if the current size matches the initial size minus one
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(list.hasCity(city), true);
        int listSize = list.getCount();
        list.deleteCity(city);
        assertEquals(list.hasCity(city), false);
        assertEquals(list.getCount(),listSize - 1);
    }

    /**
     * add a city to the list
     * check if the size returned by countCities equals 1
     * add another city to the list
     * check if the size returned by countCities equals 2
     */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(list.countCities(), 1);
        city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(list.countCities(), 2);
    }
}
