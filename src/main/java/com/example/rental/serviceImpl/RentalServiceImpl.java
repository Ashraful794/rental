package com.example.rental.serviceImpl;

import com.example.rental.dto.RentalData;
import com.example.rental.dto.RentalDataList;
import com.example.rental.dto.RentalDto;
import com.example.rental.model.Rental;
import com.example.rental.repository.RentalRepository;
import com.example.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public RentalData addRental(RentalDto rentalDto) {

        Rental rental=new Rental();

        rental.setName(rentalDto.getName());
        rental.setLocation(rentalDto.getLocation());
        rental.setCreatedAt(LocalDateTime.now());

        //entity
        rental= this.rentalRepository.save(rental);

        RentalData rentalData=new RentalData();

        rentalData.setId(rental.getId());
        rentalData.setName(rental.getName());
        rentalData.setLocation(rental.getLocation());

        return  rentalData;

    }

    @Override
    public RentalDataList getAllRental() {

        List<Rental> rentalList = this.rentalRepository.findAll();

        List<RentalData> rentalDataLists = new ArrayList<>();

        for (Rental rental1 : rentalList) {
            RentalData rentalData = new RentalData();

            rentalData.setId(rental1.getId());
            rentalData.setName(rental1.getName());
            rentalData.setLocation(rental1.getLocation());
            rentalDataLists.add(rentalData);
        }

        RentalDataList rentalDataList = new RentalDataList();

        rentalDataList.setRentalDataList(rentalDataLists);

        rentalDataList.setNoOfEntries(rentalDataLists.size());

        return rentalDataList;


    }

    @Override
    public Rental updateRental(Rental rental) throws Exception {

        Optional<Rental> rental1 = this.rentalRepository.findById(rental.getId());


        if (!rental1.isPresent()) {
            throw new Exception("Id not found");
        }
        rental.setUpdatedAt(LocalDateTime.now());
        return this.rentalRepository.save(rental);
    }

    @Override
    public String deleteRental(Rental rental) throws Exception {
        Optional<Rental> rental1 = this.rentalRepository.findById(rental.getId());
        if (!rental1.isPresent()) {
            throw new Exception("Id not found");
        }

        this.rentalRepository.delete(rental);
        return "Deleted";

    }

    @Override
    public RentalData getRental(Long id) throws Exception {

        Optional<Rental> rental=this.rentalRepository.findById(id);


        if(!rental.isPresent())
        {
            throw  new  Exception("Not Found");
        }

        RentalData rentalData=new RentalData();
        rentalData.setName(rental.get().getName());
        rentalData.setId(rental.get().getId());
        rentalData.setLocation(rental.get().getLocation());


        return rentalData;
    }


}
