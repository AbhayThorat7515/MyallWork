package com.example.tourismsystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "location")
public class LocationEntity extends AuditingEntity{

    @Column(name = "location",unique = true,length = 100)
    private String location;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "locationEntity")
    private Set<SpotEntity> spotEntitySet=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "location_package",joinColumns = {@JoinColumn(name = "location_id")},inverseJoinColumns = {@JoinColumn(name = "package_id")},uniqueConstraints =@UniqueConstraint(columnNames = {"package_id","location_id"}))
    private Set<PackageEntity> packageEntitySet=new HashSet<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<SpotEntity> getSpotEntitySet() {
        return spotEntitySet;
    }

    public void setSpotEntitySet(Set<SpotEntity> spotEntitySet) {
        this.spotEntitySet = spotEntitySet;
    }

    public Set<PackageEntity> getPackageEntitySet() {
        return packageEntitySet;
    }

    public void setPackageEntitySet(Set<PackageEntity> packageEntitySet) {
        this.packageEntitySet = packageEntitySet;
    }
}
