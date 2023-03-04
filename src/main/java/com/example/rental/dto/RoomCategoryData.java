package com.example.rental.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomCategoryData {
    private Long id;
    private String name;
    private Long price;
    private Integer no_of_rooms;
}
