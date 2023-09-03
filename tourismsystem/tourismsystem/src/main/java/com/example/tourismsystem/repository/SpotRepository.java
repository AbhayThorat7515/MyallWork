package com.example.tourismsystem.repository;

import com.example.tourismsystem.entities.SpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotRepository extends JpaRepository<SpotEntity,Long> {
}
