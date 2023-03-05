package com.example.rental.service;

import com.example.rental.dto.RentalData;
import com.example.rental.dto.RentalDataList;
import com.example.rental.dto.RentalDto;
import com.example.rental.model.Rental;

import java.util.Set;
import java.util.List;
public interface RentalService {
    RentalData addRental(RentalDto rentalDto);

    RentalDataList getAllRental();

    RentalData updateRental(RentalDto rentalDto) throws Exception;

    String deleteRental(RentalDto rentalDto) throws Exception;

    RentalData getRental(Long id) throws Exception;
}
