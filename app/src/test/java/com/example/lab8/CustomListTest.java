package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Assert;
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

    @Test
    public void testHasCity() {
        CustomList cityList = MockCityList();
        City city1 = new City("New York", "New York");
        City city2 = new City("Los Angeles", "California");

        cityList.addCity(city1);
        cityList.addCity(city2);

        assertTrue(cityList.hasCity(city1)); // City1 should be in the list
        assertTrue(cityList.hasCity(city2)); // City2 should be in the list
        assertFalse(cityList.hasCity(new City("Chicago", "Illinois"))); // City not in the list
    }

    @Test
    public void testDelete() {
        CustomList cityList = MockCityList();
        City city1 = new City("San Francisco", "California");
        City city2 = new City("Seattle", "Washington");

        cityList.addCity(city1);
        cityList.addCity(city2);

        assertTrue(cityList.hasCity(city1)); // City1 should be in the list

        // Delete city1
        cityList.delete(city1);

        assertFalse(cityList.hasCity(city1)); // City1 should no longer be in the list
        Assert.assertEquals(1, cityList.getCount()); // There should be only 1 city left

        // Try to delete city1 again, it should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });

        // Try to delete a city not in the list, it should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(new City("Chicago", "Illinois"));
        });
    }

    @Test
    public void testCountCities() {
        CustomList cityList = MockCityList();
        Assert.assertEquals(0, cityList.countCities());

        cityList.addCity(new City("Boston", "Massachusetts"));
        Assert.assertEquals(1, cityList.countCities());

        cityList.addCity(new City("Dallas", "Texas"));
        Assert.assertEquals(2, cityList.countCities());
    }

}

