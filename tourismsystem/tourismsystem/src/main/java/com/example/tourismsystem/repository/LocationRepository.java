package com.example.tourismsystem.repository;

import com.example.tourismsystem.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Long> {
    public Optional<LocationEntity> findBylocation(String location);
}
