package com.example.tourismsystem.entities;


import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BasicEntity implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
