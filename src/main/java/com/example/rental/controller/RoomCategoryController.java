package com.example.rental.controller;

import com.example.rental.model.Rental;
import com.example.rental.model.Room_Category;
import com.example.rental.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room_category")
public class RoomCategoryController {

    @Autowired
    RoomCategoryService roomCategoryService;

    @PostMapping()
    public ResponseEntity addRoomCategory(@RequestBody Room_Category request)
    {
        return ResponseEntity.ok(this.roomCategoryService.addRoomCategory(request));
    }

    @GetMapping
    public ResponseEntity getRoomCategory()
    {
        return ResponseEntity.ok(this.roomCategoryService.getRoomCategory());
    }

    @PutMapping
    public ResponseEntity updateRoomCategory(Room_Category request) throws Exception
    {
        return ResponseEntity.ok(this.roomCategoryService.updateRoomCategory(request));
    }
    @DeleteMapping
    public ResponseEntity deleteRoomCategory(Room_Category request) throws Exception
    {
        return ResponseEntity.ok(this.roomCategoryService.deleteRoomCategory(request));
    }




}
