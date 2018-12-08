package ru.itpark.servcie;

import ru.itpark.House;
import ru.itpark.repository.HouseRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseService {
    private final HouseRepository repository;

    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    public void add(House... house) {
        repository.add(house);

    }

    public List<House> findByprice(int min, int max) {
        List<House> result = new ArrayList<House>();
        for (House house : repository.getAll()) {
            if (house.getPrice() >= min && house.getPrice() <= max) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findByDistricts(String... districts) {
        throw new UnsupportedOperationException();
    }

    public List<House> findbyByDistrict(String... district) {
        List<House> result = new ArrayList<>();
        List<String> districtList = Arrays.asList(district);
        for (House house : repository.getAll()) {
            if (districtList.contains((house.getDisrict()))){
                result.add(house);
            }
        }
        return result;
    }
}
