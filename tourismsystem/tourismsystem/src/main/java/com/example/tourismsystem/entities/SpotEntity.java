package com.example.tourismsystem.entities;


import javax.persistence.*;

@Entity
@Table(name = "spot")
public class SpotEntity extends AuditingEntity{

    @Column(name = "name",unique = true,length = 100)
    private String name;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private LocationEntity locationEntity=new LocationEntity();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }
}
