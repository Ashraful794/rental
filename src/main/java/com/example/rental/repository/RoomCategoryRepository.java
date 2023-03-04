package com.example.rental.repository;

import com.example.rental.model.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomCategoryRepository extends JpaRepository<RoomCategory,Long> {
    List<RoomCategory> findByRentalId(Long id);
}
