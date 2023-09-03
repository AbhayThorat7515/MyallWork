package com.example.tourismsystem.service;

import com.example.tourismsystem.dto.PackageDto;
import com.example.tourismsystem.dto.UserDto;
import com.example.tourismsystem.dto.UserPackageDto;
import com.example.tourismsystem.entities.PackageEntity;
import com.example.tourismsystem.entities.UserEntity;
import com.example.tourismsystem.exceptionutility.CustomeException;
import com.example.tourismsystem.repository.PackageReposistory;
import com.example.tourismsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PackageReposistory packageReposistory;
    @Autowired
    UserRepository userRepository;

    @Override
    public UserPackageDto booking(Long packageid, UserDto userDto) {
        UserPackageDto userPackageDto = new UserPackageDto();


        Optional<PackageEntity> optionalPackageEntity = packageReposistory.findById(packageid);
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(userDto.getEmail());
        try {
            if (optionalPackageEntity.isPresent() && optionalUserEntity.isPresent()) {
                UserEntity userEntity = optionalUserEntity.get();
                PackageEntity packageEntity = optionalPackageEntity.get();
                userPackageDto.setPackageDto(new PackageDto(packageEntity.getPackageName(),packageEntity.getDuration(),packageEntity.getPrice()));
                userEntity.getPackageEntitySet().add(packageEntity);
                userRepository.save(userEntity);
            } else if (optionalPackageEntity.isPresent() && !optionalUserEntity.isPresent()) {
                PackageEntity packageEntity = optionalPackageEntity.get();
                UserEntity userEntity = new UserEntity();
                userEntity.setFirstName(userDto.getFirstName());
                userEntity.setLastName(userDto.getLastName());
                userEntity.setEmail(userDto.getEmail());
                userEntity.setDateOfJourney(userDto.getDateOfJourney());
                userEntity.getPackageEntitySet().add(packageEntity);
                userPackageDto.setPackageDto(new PackageDto(packageEntity.getPackageName(),packageEntity.getDuration(),packageEntity.getPrice()));
                userRepository.save(userEntity);


            }
            else if(!optionalPackageEntity.isPresent()){

                throw new CustomeException(500,"id not present");

               // return new ResponseEntity.ok().body(new ResponseDto(500,"id not present","try again"));
              //  return new ResponseEntity<>("kkk").getStatusCode();

            }
        } catch (NoSuchElementException noSuchElementException) {
            throw new CustomeException(600, "package id not present");

        }

        userPackageDto.setUser(new UserDto(userDto.getFirstName(),userDto.getLastName(),userDto.getEmail(),userDto.getDateOfJourney()));



        return userPackageDto;
    }
}
