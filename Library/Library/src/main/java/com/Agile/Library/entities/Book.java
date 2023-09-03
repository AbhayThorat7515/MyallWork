
package com.Agile.Library.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid", nullable = false)
    private Long bid;

    @Column(name = "bname")
    private String bname;

    @Column(name = "quantity")
    private Integer quantity;


    @Column(name = "available")
    private String availableBook;


    // IT IS FOR A RACK BOOK
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rack_no")
    private Rack rack_no;



    // IT IS FOR BOOK TO ISSUE BOOK
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bid")
    private List<BookIssue> b_issue_no;

    public List<BookIssue> getB_issue_no() {
        return b_issue_no;
    }

    public void setB_issue_no(List<BookIssue> b_issue_no) {
        this.b_issue_no = b_issue_no;
    }


    public Rack getRack_no() {
        return rack_no;
    }

    public void setRack_no(Rack rack_no) {
        this.rack_no = rack_no;
    }


    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAvailableBook() {
        return availableBook;
    }

    public void setAvailableBook(String availableBook) {
        this.availableBook = availableBook;
    }

    public Book() {
    }

    public Book(Long bid, String bname, Integer quantity, String availableBook) {
        this.bid = bid;
        this.bname = bname;
        this.quantity = quantity;
        this.availableBook = availableBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", quantity=" + quantity +
                ", availableBook='" + availableBook + '\'' +
                '}';
    }
}

