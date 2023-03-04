package com.example.rental.serviceImpl;

import com.example.rental.dto.RoomCategoryData;
import com.example.rental.dto.RoomCategoryDataList;
import com.example.rental.dto.RoomCategoryDto;
import com.example.rental.model.Rental;
import com.example.rental.model.RoomCategory;
import com.example.rental.repository.RoomCategoryRepository;
import com.example.rental.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    @Autowired
    RoomCategoryRepository roomCategoryRepository;


    @Override
    public RoomCategoryDto addRoomCategory(RoomCategoryDto roomCategoryDto) {

        RoomCategory roomCategory=new RoomCategory();

        Rental rental=new Rental();

        rental.setId(roomCategoryDto.getRentalId());
        roomCategory.setName(roomCategoryDto.getName());
        roomCategory.setPrice(roomCategoryDto.getPrice());
        roomCategory.setNo_of_rooms(roomCategory.getNo_of_rooms());
        roomCategory.setRental(rental);

        roomCategory = this.roomCategoryRepository.save(roomCategory);

        roomCategoryDto.setId(roomCategory.getId());
        roomCategoryDto.setPrice(roomCategory.getPrice());
        roomCategoryDto.setName(roomCategory.getName());
        roomCategoryDto.setNo_of_rooms(roomCategory.getNo_of_rooms());
        roomCategoryDto.setRentalId(roomCategory.getRental().getId());

        return roomCategoryDto;
    }

    @Override
    public RoomCategoryDataList getAllRoomCategory() {

        List<RoomCategory> roomCategory=this.roomCategoryRepository.findAll();

        List<RoomCategoryData> roomCategoryData=new ArrayList<>();

        for (RoomCategory roomCategory1:roomCategory)
        {
            RoomCategoryData roomCategoryData1=new RoomCategoryData();
            roomCategoryData1.setId(roomCategory1.getId());
            roomCategoryData1.setName(roomCategory1.getName());
            roomCategoryData1.setPrice(roomCategory1.getPrice());
            roomCategoryData1.setNo_of_rooms(roomCategory1.getNo_of_rooms());

            roomCategoryData.add(roomCategoryData1);
        }

        RoomCategoryDataList roomCategoryDataList=new RoomCategoryDataList();
        roomCategoryDataList.setRoomCategoryData(roomCategoryData);
        roomCategoryDataList.setNoOfEntries(roomCategoryData.size());




        return roomCategoryDataList;
    }

    @Override
    public RoomCategoryData getRoomCategoryById(Long id) throws Exception{
        Optional<RoomCategory> roomCategory=this.roomCategoryRepository.findById(id);

        if(!roomCategory.isPresent())
        {
            throw new Exception("Not Found");
        }

        RoomCategoryData roomCategoryData=new RoomCategoryData();

        roomCategoryData.setId(roomCategory.get().getId());
        roomCategoryData.setName(roomCategory.get().getName());
        roomCategoryData.setPrice(roomCategory.get().getPrice());
        roomCategoryData.setNo_of_rooms(roomCategory.get().getNo_of_rooms());

        return  roomCategoryData;
    }

    @Override
    public RoomCategoryDataList getRoomCategoryByRentalId(Long id) throws Exception {
        List<RoomCategory> roomCategory=this.roomCategoryRepository.findByRentalId(id);

        List<RoomCategoryData> roomCategoryData=new ArrayList<>();

        for(RoomCategory roomCategory1:roomCategory)
        {
            RoomCategoryData roomCategoryData1=new RoomCategoryData();
            roomCategoryData1.setId(roomCategory1.getId());
            roomCategoryData1.setName(roomCategory1.getName());
            roomCategoryData1.setPrice(roomCategory1.getPrice());
            roomCategoryData1.setNo_of_rooms(roomCategoryData1.getNo_of_rooms());

            roomCategoryData.add(roomCategoryData1);
        }
        RoomCategoryDataList roomCategoryDataList=new RoomCategoryDataList();
        roomCategoryDataList.setRoomCategoryData(roomCategoryData);
        roomCategoryDataList.setNoOfEntries(roomCategoryData.size());
        return  roomCategoryDataList;
    }

    @Override
    public RoomCategory updateRoomCategory(RoomCategory roomCategory) throws Exception {

        Optional<RoomCategory> room_category=this.roomCategoryRepository.findById(roomCategory.getId());
        if (!room_category.isPresent())
        {
            throw new Exception("Id Not Found");
        }
        return this.roomCategoryRepository.save(roomCategory);
    }

    @Override
    public String deleteRoomCategory(RoomCategory roomCategory) throws Exception {
        Optional<RoomCategory> room_category=this.roomCategoryRepository.findById(roomCategory.getId());
        if (!room_category.isPresent())
        {
            throw new Exception("Id Not Found");
        }
        this.roomCategoryRepository.delete(roomCategory);
        return "Deleted";
    }
}
