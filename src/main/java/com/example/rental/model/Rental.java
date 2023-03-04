package com.example.rental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "rental")
    @JsonIgnore
    private List<RoomCategory> roomCategory;
}
