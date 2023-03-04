package com.example.rental.serviceImpl;

import com.example.rental.model.Room_Category;
import com.example.rental.repository.Room_CategoryRepository;
import com.example.rental.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    @Autowired
    Room_CategoryRepository roomCategoryRepository;
    @Override
    public Room_Category addRoomCategory(Room_Category roomCategory) {
        return this.roomCategoryRepository.save(roomCategory);
    }

    @Override
    public List<Room_Category> getRoomCategory() {
        return this.roomCategoryRepository.findAll();
    }

    @Override
    public Room_Category updateRoomCategory(Room_Category roomCategory) throws Exception {

        Optional<Room_Category> room_category=this.roomCategoryRepository.findById(roomCategory.getId());
        if (!room_category.isPresent())
        {
            throw new Exception("Id Not Found");
        }
        return this.roomCategoryRepository.save(roomCategory);
    }

    @Override
    public String deleteRoomCategory(Room_Category roomCategory) throws Exception {
        Optional<Room_Category> room_category=this.roomCategoryRepository.findById(roomCategory.getId());
        if (!room_category.isPresent())
        {
            throw new Exception("Id Not Found");
        }
        this.roomCategoryRepository.delete(roomCategory);
        return "Deleted";
    }
}
