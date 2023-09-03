package com.example.tourismsystem.service;

import com.example.tourismsystem.dto.*;
import com.example.tourismsystem.entities.LocationEntity;
import com.example.tourismsystem.entities.PackageEntity;
import com.example.tourismsystem.entities.SpotEntity;
import com.example.tourismsystem.entities.UserEntity;
import com.example.tourismsystem.exceptionutility.CustomeException;
import com.example.tourismsystem.repository.LocationRepository;
import com.example.tourismsystem.repository.PackageReposistory;
import com.example.tourismsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PackageServiceImpl implements PackageService {
    @Autowired
    PackageReposistory packageReposistory;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public PackageDto createPackage(PackageDto packageDto) {

        PackageEntity packageEntity = new PackageEntity();
        if (packageDto != null) {
            try {
                packageEntity.setPackageName(packageDto.getPackageName());
                packageEntity.setDuration(packageDto.getDuration());
                packageEntity.setPrice(packageDto.getPrice());
                packageReposistory.save(packageEntity);
            } catch (Exception e) {
                throw new CustomeException(500,"name already present");
            }
        }
        return packageDto;
    }


    @Override
    public boolean addPackageandLOcation(Long packageid, Long locationid) {


        try {
            Optional<PackageEntity> optionalPackageEntity = packageReposistory.findById(packageid);
            PackageEntity packageEntity = optionalPackageEntity.get();
            Optional<LocationEntity> optionalLocationEntity = locationRepository.findById(locationid);
            LocationEntity locationEntity = optionalLocationEntity.get();
            PackageEntity packageEntity1 = new PackageEntity();

            if (optionalPackageEntity.isPresent() && optionalLocationEntity.isPresent()) {

                packageEntity.getLocationEntitySet().add(locationEntity);
                packageReposistory.save(packageEntity);
            }

        } catch (NoSuchElementException e) {

            throw new CustomeException(500, "id not present...check it correctly");
        }

        return true;
    }


    @Override
    public List<PackageDto> listOfPackage() {
        List<PackageEntity> packageEntityList = packageReposistory.findAll();

        List<PackageDto> packageDtoList = new ArrayList<>();
        if (!packageEntityList.isEmpty()) {
            for (PackageEntity packageEntity : packageEntityList) {
                PackageDto packageDto = new PackageDto();
                packageDto.setPackageName(packageEntity.getPackageName());
                packageDto.setDuration(packageEntity.getDuration());
                packageDto.setPrice(packageEntity.getPrice());
                packageDtoList.add(packageDto);

            }
        } else {
            throw new CustomeException(600, "list is empty");
        }
        return packageDtoList;
    }

    @Override
    public HistoryOfUserResponseDto getPackageDeatils(Long userid) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userid);

        HistoryOfUserResponseDto historyOfUserResponseDto = new HistoryOfUserResponseDto();
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
           // UserDto userDto = new UserDto();
            historyOfUserResponseDto.setFirstName(userEntity.getFirstName());
            historyOfUserResponseDto.setLastName(userEntity.getLastName());
            historyOfUserResponseDto.setEmail(userEntity.getEmail());
            historyOfUserResponseDto.setDateOfJourney(userEntity.getDateOfJourney());
          //  historyOfUserResponseDto.setUserDto(userDto);
            Set<PackageDto> packageDtoList = new HashSet<>();
            for (PackageEntity packageEntity : userEntity.getPackageEntitySet()) {
                PackageDto packageDto = new PackageDto();
                packageDto.setPackageName(packageEntity.getPackageName());
                packageDto.setPrice(packageEntity.getPrice());
                packageDto.setDuration(packageEntity.getDuration());

                packageDtoList.add(packageDto);
                historyOfUserResponseDto.setPackageDto(packageDtoList);
                Set<LocationDto> locationDtoSet = new HashSet<>();
                for (LocationEntity locationEntity : packageEntity.getLocationEntitySet()) {

                    LocationDto locationDto = new LocationDto();
                    locationDto.setLocation(locationEntity.getLocation());

                    locationDtoSet.add(locationDto);
                    packageDto.setLocationDtoSet(locationDtoSet);
                  //  historyOfUserResponseDto.setLocationDtos(locationDtoSet);
                    List<SpotDto> spotDtos = new ArrayList<>();
                    for (SpotEntity spotEntity : locationEntity.getSpotEntitySet()) {

                        SpotDto spotDto = new SpotDto();
                        spotDto.setName(spotEntity.getName());
                        locationDto.setSpotDtos(spotDtos);
                        spotDtos.add(spotDto);
                      //  historyOfUserResponseDto.setSpotDtoset(spotDtos);
                    }


                }


            }


        }


        return historyOfUserResponseDto;
    }

    @Override
    public List<UserIdPackageDto> listOfPackageByUserId(Long userid) {

        Optional<UserEntity> optionalUserEntity=userRepository.findById(userid);
       List<UserIdPackageDto> packageDtoList=new ArrayList<>();
        UserIdPackageDto userPackageDto=new UserIdPackageDto();
        if(optionalUserEntity.isPresent()){
           // UserDto userDto=new UserDto();

            UserEntity userEntity= optionalUserEntity.get();
            userPackageDto.setFirstName(userEntity.getFirstName());
            userPackageDto.setLastName(userEntity.getLastName());
            userPackageDto.setEmail(userEntity.getEmail());
            userPackageDto.setDateOfJourney(userEntity.getDateOfJourney());
           // userPackageDto.setUser(userDto);
            Set<PackageDtos> packageDtos=new HashSet<>();
            for(PackageEntity packageEntity:userEntity.getPackageEntitySet()){

                PackageDtos packageDto=new PackageDtos();
                packageDto.setPackageName(packageEntity.getPackageName());
                packageDto.setDuration(packageEntity.getDuration());
                packageDto.setPrice(packageEntity.getPrice());
                packageDtos.add(packageDto);
                userPackageDto.setPackageDtoSet(packageDtos);


            }

packageDtoList.add(userPackageDto);
        }




        return packageDtoList;
    }

    @Override
    public List<PackageLocationDto> listOfLocationByPackage(Long packageid) {

        Optional<PackageEntity> optionalPackageEntity=packageReposistory.findById(packageid);
        List<PackageLocationDto> packageLocationDtos=new ArrayList<>();

        PackageLocationDto packageLocationDto=new PackageLocationDto();
        if(optionalPackageEntity.isPresent()){

            PackageEntity packageEntity= optionalPackageEntity.get();

//            PackageDto packageDto=new PackageDto();
//            packageDto.setPackageName(packageEntity.getPackageName());
      //      packageDto.setPrice(packageEntity.getPrice());
         //   packageDto.setDuration(packageEntity.getDuration());
            packageLocationDto.setPackageName(packageEntity.getPackageName());
            packageLocationDto.setDuration(packageEntity.getDuration());
            packageLocationDto.setPrice(packageEntity.getPrice());
            Set<LocationDto> locationDtoSet=new HashSet<>();
            for(LocationEntity locationEntity:packageEntity.getLocationEntitySet()){


                LocationDto locationDto=new LocationDto();
                locationDto.setLocation(locationEntity.getLocation());
                locationDtoSet.add(locationDto);
                packageLocationDto.setLocationDtoList(locationDtoSet);

            }
            packageLocationDtos.add(packageLocationDto);

        }
        else {
            throw  new CustomeException(600,"id not present");
        }


        return packageLocationDtos;
    }

//    @Override
//    public PackageLocationSpotDto getLocationAndSpotByPackageid(Long packageid){
//
//
//        Optional<PackageEntity> optionalPackageEntity=packageReposistory.findById(packageid);
//      //  List<PackageLocationDto> packageLocationDtos=new ArrayList<>();
//
//        PackageLocationSpotDto packageLocationDto=new PackageLocationSpotDto();
//        if(optionalPackageEntity.isPresent()){
//
//            PackageEntity packageEntity= optionalPackageEntity.get();
//            packageLocationDto.setPackageName(packageEntity.getPackageName());
//            packageLocationDto.setDuration(packageEntity.getDuration());
//            packageLocationDto.setPrice(packageEntity.getPrice());
//            Set<LocationDto> locationDtoSet=new HashSet<>();
//            for(LocationEntity locationEntity:packageEntity.getLocationEntitySet()){
//
//
//                LocationDto locationDto=new LocationDto();
//                locationDto.setLocation(locationEntity.getLocation());
//                locationDtoSet.add(locationDto);
//                packageLocationDto.setLocationDtos(locationDtoSet);
//
//            }
//          //  packageLocationDtos.add(packageLocationDto);
//
//        }
//        else {
//            throw  new CustomeException(600,"id not present");
//        }
//
//
//        return packageLocationDto;
//
//
//
//
//    }

    @Override
    public PackageLocationSpotDto getLoacationSpotbyPackageId(Long packageid) {
        Optional<PackageEntity> optionalPackageEntity=packageReposistory.findById(packageid);
        //  List<PackageLocationDto> packageLocationDtos=new ArrayList<>();

        PackageLocationSpotDto packageLocationDto=new PackageLocationSpotDto();
        if(optionalPackageEntity.isPresent()){

            PackageEntity packageEntity= optionalPackageEntity.get();
            packageLocationDto.setPackageName(packageEntity.getPackageName());
            packageLocationDto.setDuration(packageEntity.getDuration());
            packageLocationDto.setPrice(packageEntity.getPrice());
            Set<LocationDto> locationDtoSet=new HashSet<>();
            for(LocationEntity locationEntity:packageEntity.getLocationEntitySet()){


                LocationDto locationDto=new LocationDto();
                locationDto.setLocation(locationEntity.getLocation());
                locationDtoSet.add(locationDto);
                packageLocationDto.setLocationDtos(locationDtoSet);

                List<SpotDto> spotDtos=new ArrayList<>();
                for(SpotEntity spotEntity:locationEntity.getSpotEntitySet()){

                    SpotDto spotDto=new SpotDto();
                    spotDto.setName(spotEntity.getName());
                    spotDtos.add(spotDto);
                    locationDto.setSpotDtos(spotDtos);


                }

            }
            //  packageLocationDtos.add(packageLocationDto);

        }
        else {
            throw  new CustomeException(600,"id not present");
        }


        return packageLocationDto;


    }
}
