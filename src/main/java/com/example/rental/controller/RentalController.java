package com.example.rental.controller;

import com.example.rental.dto.RentalData;
import com.example.rental.dto.RentalDataList;
import com.example.rental.dto.RentalDto;
import com.example.rental.model.Rental;
import com.example.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;

@RestController
@RequestMapping("/api/rental")
public class RentalController {

    @Autowired
    private  RentalService rentalService;

    @PostMapping("/add")
    public ResponseEntity<RentalData> addRental(@RequestBody RentalDto rentalDto)
    {
        return new ResponseEntity(this.rentalService.addRental(rentalDto),HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<RentalDataList> getAllRental()
    {
        return new ResponseEntity(this.rentalService.getAllRental(), HttpStatus.OK);
    }
    @PutMapping("/put")
    public ResponseEntity updateRental(@RequestBody Rental rental) throws Exception
    {
        return ResponseEntity.ok(this.rentalService.updateRental(rental));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteRental(@RequestBody Rental rental) throws Exception
    {
        return ResponseEntity.ok(this.rentalService.deleteRental(rental));
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<RentalData> getRental(@PathVariable Long id) throws Exception
    {
        return new ResponseEntity(this.rentalService.getRental(id), HttpStatus.OK);
    }


}
