package com.example.rental.controller;

import com.example.rental.model.Rental;
import com.example.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;

@RestController
@RequestMapping("/api/rental")
public class RentalController {

    @Autowired
    private  RentalService rentalService;

    @PostMapping()
    public ResponseEntity addRental(@RequestBody Rental request)
    {
        return ResponseEntity.ok(this.rentalService.addRental(request));
    }
    @GetMapping()
    public ResponseEntity getRental()
    {
        return ResponseEntity.ok(this.rentalService.getRental());
    }
    @PutMapping()
    public ResponseEntity updateRental(@RequestBody Rental rental) throws Exception
    {
        return ResponseEntity.ok(this.rentalService.updateRental(rental));
    }

    @DeleteMapping()
    public ResponseEntity deleteRental(@RequestBody Rental rental) throws Exception
    {
        return ResponseEntity.ok(this.rentalService.deleteRental(rental));
    }



}
