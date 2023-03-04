package com.example.rental.repository;

import com.example.rental.model.Room_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Room_CategoryRepository extends JpaRepository<Room_Category,Long> {
}
