package com.example.rental.service;

import com.example.rental.model.Room_Category;

import java.util.List;

public interface RoomCategoryService {
    Room_Category addRoomCategory(Room_Category roomCategory);
    List<Room_Category> getRoomCategory();
    Room_Category updateRoomCategory(Room_Category roomCategory) throws Exception;
    String deleteRoomCategory(Room_Category roomCategory) throws Exception;
}
