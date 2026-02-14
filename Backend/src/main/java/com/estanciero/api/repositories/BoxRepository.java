package com.estanciero.api.repositories;

import com.estanciero.api.models.entities.boxes.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {


    List<Box> findAllByOrderByPositionAsc();
}
