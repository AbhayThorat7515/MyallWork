package com.example.tourismsystem.repository;

import com.example.tourismsystem.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageReposistory extends JpaRepository<PackageEntity,Long> {


}
