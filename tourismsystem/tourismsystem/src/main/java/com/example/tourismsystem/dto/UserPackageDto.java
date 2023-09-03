package com.example.tourismsystem.dto;

public class UserPackageDto {

    private UserDto user=new UserDto();
    private PackageDto packageDto=new PackageDto();

    public UserPackageDto() {
    }

    public UserPackageDto(UserDto user, PackageDto packageDto) {
        this.user = user;
        this.packageDto = packageDto;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PackageDto getPackageDto() {
        return packageDto;
    }

    public void setPackageDto(PackageDto packageDto) {
        this.packageDto = packageDto;
    }
}
