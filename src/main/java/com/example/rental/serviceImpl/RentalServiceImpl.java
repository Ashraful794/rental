package com.example.rental.serviceImpl;

import com.example.rental.model.Rental;
import com.example.rental.repository.RentalRepository;
import com.example.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Rental addRental(Rental rental) {
        rental.setCreated_at(LocalDateTime.now());
        return this.rentalRepository.save(rental);
    }

    @Override
    public List<Rental> getRental() {
        return this.rentalRepository.findAll();
    }

    @Override
    public Rental updateRental(Rental rental) throws Exception {

        Optional<Rental> rental1=this.rentalRepository.findById(rental.getId());


        if(!rental1.isPresent())
        {
            throw  new Exception("Id not found");
        }
        rental.setUpdated_at(LocalDateTime.now());
        return this.rentalRepository.save(rental);
    }

    @Override
    public String deleteRental(Rental rental) throws Exception {
        Optional<Rental> rental1=this.rentalRepository.findById(rental.getId());
        if(!rental1.isPresent())
        {
            throw  new Exception("Id not found");
        }

        this.rentalRepository.delete(rental);
        return "Deleted";

    }


}
