package com.example.rental.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Setter
@Getter

public class RentalDto {

    private Long id;
    private String name;
    private String location;

}
