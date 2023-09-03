package com.example.tourismsystem.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity extends AuditingEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "date_of_journey")
    private Date dateOfJourney;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_package",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "package_id")},uniqueConstraints =@UniqueConstraint(columnNames = {"package_id","user_id"}))
    private Set<PackageEntity> packageEntitySet=new HashSet<>();

    public Set<PackageEntity> getPackageEntitySet() {
        return packageEntitySet;
    }

    public void setPackageEntitySet(Set<PackageEntity> packageEntitySet) {
        this.packageEntitySet = packageEntitySet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(Date dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }
}
