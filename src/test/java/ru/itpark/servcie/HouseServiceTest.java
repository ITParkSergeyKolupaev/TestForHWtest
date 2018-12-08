package ru.itpark.servcie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.House;
import ru.itpark.repository.HouseRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseServiceTest {
    private HouseService service;
    @BeforeEach
    void setUp() {
        HouseRepository repository = new HouseRepository();
        repository.add(new House(1,null, 1_000_000,"New-Savinovsky",null),
                       new House(2,null, 4_000_000,"New-Savinovsky",null),
                       new House(3,null, 900_000,"Kirovsky",null),
                       new House(4,null, 5_000_000,"Aviastroy",null));
        service =new HouseService(repository);
    }

    @Test
    public void FindByPriceWithZeroResults(){

        {
            List<House> result = service.findByprice(10_000_000, 100_000_000);
            assertEquals(0, result.size());
        }
        {
            List<House> result = service.findByprice(0, 500_000);
            assertEquals(0, result.size());
        }
    }

    @Test
    public void FindByPriceWithOneResults(){
        int minPrice = 2_000_000;
        int maxPrice = 4_500_000;
        List<House> result = service.findByprice(minPrice, maxPrice);
        assertEquals(1,result.size());

        int price = result.get(0).getPrice();
        assertTrue(price >= minPrice);
        assertTrue(price <= maxPrice);
    }

    @Test
    public void FindByPriceWithMultiplieResults(){
        int minPrice = 1_000_000;
        int maxPrice = 5_000_000;
        List<House> result = service.findByprice(minPrice, maxPrice);
        assertEquals(3,result.size());
        for (House house : result) {
            int price = house.getPrice();
            assertTrue(price >= minPrice);
            assertTrue(price <= maxPrice);
        }
    }
    @Test
    public void findByDistrictsWithmulripliResults(){
        List<House> result = service.findbyByDistrict("New-Savinovsky", "Aviastroy");
        assertEquals(3,result.size());
    }

}