package com.example.rental.dto;

import com.example.rental.model.Rental;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RentalDataList {
    private  List<RentalData> rentalDataList;
    private Integer noOfEntries;
}
