package com.example.tourismsystem.service;

import com.example.tourismsystem.dto.UserDto;
import com.example.tourismsystem.dto.UserPackageDto;

public interface UserService {


    public UserPackageDto booking(Long packageid, UserDto userDto);


}
