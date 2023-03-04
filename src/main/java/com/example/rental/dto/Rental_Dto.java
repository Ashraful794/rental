package com.example.rental.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class Rental_Dto {
    private Long id;
    private String name;
    private String location;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
