package com.example.tourismsystem.repository;

import com.example.tourismsystem.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    public Optional<UserEntity> findByEmail(String emailid);
}
