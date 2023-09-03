package com.Agile.Library.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rack")
public class Rack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rack_no", nullable = false)
    private Long rackNo;


    @Column(name = "rack_name")
    private String rackName;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rack_no")
    private List<Book> bookNo;

    public Long getRackNo() {
        return rackNo;
    }

    public void setRackNo(Long rackNo) {
        this.rackNo = rackNo;
    }

    public String getRackName() {
        return rackName;
    }

    public void setRackName(String rackName) {
        this.rackName = rackName;
    }

    public List<Book> getBookNo() {
        return bookNo;
    }

    public void setBookNo(List<Book> bookNo) {
        this.bookNo = bookNo;
    }

    public Rack(Long rackNo, String rackName ) {
        this.rackNo = rackNo;
        this.rackName = rackName;

    }

    public Rack(String rackName ) {
        this.rackName = rackName;

    }

    public Rack() {
    }

    @Override
    public String toString() {
        return "Rack{" +
                "rackNo=" + rackNo +
                ", rackName='" + rackName + '\'' +
                '}';
    }
}
