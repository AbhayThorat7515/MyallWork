package com.Agile.Library.entities;

import javax.persistence.*;


@Entity
@Table(name = "shelf")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "shelf_no", nullable = false)
    private Long shelfNo;

    @Column(name = "shelf_name")
    private String shelfName;


    public Long getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(Long shelfNo) {
        this.shelfNo = shelfNo;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public Shelf(Long shelfNo, String shelfName) {
        this.shelfNo = shelfNo;
        this.shelfName = shelfName;
    }

    public Shelf() {
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "shelfNo=" + shelfNo +
                ", shelfName='" + shelfName + '\'' +
                '}';
    }
}
