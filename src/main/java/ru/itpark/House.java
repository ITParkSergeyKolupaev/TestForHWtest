package ru.itpark;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class House {

    private int id;
    private String title;
    private int price;
    private String disrict;
    private List<String> tags;

}
