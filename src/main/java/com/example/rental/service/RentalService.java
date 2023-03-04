package com.example.rental.service;

import com.example.rental.model.Rental;

import java.util.Set;
import java.util.List;
public interface RentalService {
    Rental addRental(Rental rental);

    List<Rental> getRental();

    Rental updateRental(Rental rental) throws Exception;

    String deleteRental(Rental rental) throws Exception;
}
