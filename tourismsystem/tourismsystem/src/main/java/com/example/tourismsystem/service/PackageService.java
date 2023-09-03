package com.example.tourismsystem.service;

import com.example.tourismsystem.dto.*;

import java.util.List;

public interface PackageService {
    public PackageDto createPackage(PackageDto packageDto);
    public boolean addPackageandLOcation(Long packageid,Long locationid);
    public List<PackageDto>  listOfPackage();
    public HistoryOfUserResponseDto getPackageDeatils(Long userid);

    public  List<UserIdPackageDto> listOfPackageByUserId(Long userid);

    public  List<PackageLocationDto> listOfLocationByPackage(Long packageid);
    public PackageLocationSpotDto getLoacationSpotbyPackageId(Long packageid);


}
