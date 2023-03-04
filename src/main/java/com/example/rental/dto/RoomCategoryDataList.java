package com.example.rental.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RoomCategoryDataList {

    private List<RoomCategoryData> roomCategoryData;
    private Integer noOfEntries;
}
