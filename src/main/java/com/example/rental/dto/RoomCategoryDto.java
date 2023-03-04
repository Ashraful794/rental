package com.example.rental.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomCategoryDto {
    private Long id;
    private String name;
    private Long price;
    private Integer no_of_rooms;
    private Long rentalId;
}
