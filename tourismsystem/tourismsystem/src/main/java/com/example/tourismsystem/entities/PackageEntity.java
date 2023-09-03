package com.example.tourismsystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "package")
public class PackageEntity extends AuditingEntity{

    @Column(name = "package_name",unique = true,length = 100)
    private String packageName;
    @Column(name = "duration")
    private String duration;
    @Column(name = "price")
    private Long price;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_package",joinColumns = {@JoinColumn(name = "package_id")},inverseJoinColumns = {@JoinColumn(name = "user_id")},uniqueConstraints =@UniqueConstraint(columnNames = {"package_id","user_id"}))
    private Set<UserEntity> userEntitySet=new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "location_package",joinColumns = {@JoinColumn(name = "package_id")},inverseJoinColumns = {@JoinColumn(name = "location_id")},uniqueConstraints =@UniqueConstraint(columnNames = {"package_id","location_id"}))
    private Set<LocationEntity> locationEntitySet=new HashSet<>();


    public Set<UserEntity> getUserEntitySet() {
        return userEntitySet;
    }

    public void setUserEntitySet(Set<UserEntity> userEntitySet) {
        this.userEntitySet = userEntitySet;
    }

    public Set<LocationEntity> getLocationEntitySet() {
        return locationEntitySet;
    }

    public void setLocationEntitySet(Set<LocationEntity> locationEntitySet) {
        this.locationEntitySet = locationEntitySet;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
