package com.example.rental.controller;

import com.example.rental.dto.RoomCategoryData;
import com.example.rental.dto.RoomCategoryDataList;
import com.example.rental.dto.RoomCategoryDto;
import com.example.rental.model.RoomCategory;
import com.example.rental.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roomcategory")
public class RoomCategoryController {

    @Autowired
    RoomCategoryService roomCategoryService;

    @PostMapping("/add")
    public ResponseEntity<RoomCategoryDto> addRoomCategory(@RequestBody RoomCategoryDto request)
    {
        return new ResponseEntity(this.roomCategoryService.addRoomCategory(request),HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity getRoomCategory()
    {
        return new ResponseEntity(this.roomCategoryService.getAllRoomCategory(), HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<RoomCategoryData> updateRoomCategory(RoomCategoryDto request) throws Exception
    {
        return new ResponseEntity(this.roomCategoryService.updateRoomCategory(request),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteRoomCategory(RoomCategoryDto request) throws Exception
    {
        return new ResponseEntity(this.roomCategoryService.deleteRoomCategory(request),HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<RoomCategoryData> getRoomCategoryById(@PathVariable Long id) throws Exception
    {
        return new ResponseEntity(this.roomCategoryService.getRoomCategoryById(id),HttpStatus.OK);
    }
    @GetMapping("/getbyrentalid/{id}")
    public ResponseEntity<RoomCategoryDataList> getRoomCategoryByRentalId(@PathVariable Long id) throws Exception
    {
        return new ResponseEntity(this.roomCategoryService.getRoomCategoryByRentalId(id),HttpStatus.OK);
    }



}
