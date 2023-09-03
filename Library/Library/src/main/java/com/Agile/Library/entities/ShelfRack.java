package com.Agile.Library.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shelfrack")
public class ShelfRack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shelfrack_no", nullable = false)
    private Long shelfrack_no;


    //MANY TO MANY FORMAT
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ShelfRack.class)
    @JoinTable(name = "shelfrack", joinColumns = @JoinColumn(name = "shelf_no"), inverseJoinColumns = @JoinColumn(name = "rack_no"))
    private List<ShelfRack> shelfrack;

    public List<ShelfRack> getShelfrack() {
        return shelfrack;
    }

    public void setShelfrack(List<ShelfRack> shelfrack) {
        this.shelfrack = shelfrack;
    }
////


    public Long getShelfrack_no() {
        return shelfrack_no;
    }
    public void setShelfrack_no(Long shelfrack_no) {
        this.shelfrack_no = shelfrack_no;
    }


}
