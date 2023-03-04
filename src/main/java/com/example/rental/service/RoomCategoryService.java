package com.example.rental.service;

import com.example.rental.dto.RoomCategoryData;
import com.example.rental.dto.RoomCategoryDataList;
import com.example.rental.dto.RoomCategoryDto;
import com.example.rental.model.RoomCategory;

import java.util.List;

public interface RoomCategoryService {
    RoomCategoryDto addRoomCategory(RoomCategoryDto roomCategoryDto);
    RoomCategoryDataList getAllRoomCategory();
    RoomCategoryData getRoomCategoryById(Long id) throws Exception;
    RoomCategoryDataList getRoomCategoryByRentalId(Long id) throws Exception;
    RoomCategory updateRoomCategory(RoomCategory roomCategory) throws Exception;
    String deleteRoomCategory(RoomCategory roomCategory) throws Exception;

}
