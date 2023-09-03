package com.Agile.Library.entities;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookissue")
public class BookIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "b_issue_no", nullable = false)
    private Long BookIssueNo;

    @Column(name = "issue_date" , nullable = false)
    private Date IssueDate ;

    @Column(name = "return_date", nullable = false)
    private Date ReturnDate;

    @Column(name = "status", nullable = false)
    private String Status;



    //to join Book table
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bid")
    private Book bid;

    public Book getBid() {
        return bid;
    }

    public void setBid(Book bid) {
        this.bid = bid;
    }


    //Student name join
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Student id;

    public Student getId() {
        return id;
    }

    public void setId(Student id
    ) {
        this.id = id;
    }



    //NORMAL GETER AND SETER OFF ENTITY


    public Long getBookIssueNo() {
        return BookIssueNo;
    }

    public void setBookIssueNo(Long bookIssueNo) {
        BookIssueNo = bookIssueNo;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date returnDate) {
        ReturnDate = returnDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public BookIssue(Long bookIssueNo, Date issueDate, Date returnDate, String status) {
        BookIssueNo = bookIssueNo;
        IssueDate = issueDate;
        ReturnDate = returnDate;
        Status = status;
    }

    public BookIssue() {
    }

    @Override
    public String toString() {
        return "BookIssue{" +
                "BookIssueNo=" + BookIssueNo +
                ", IssueDate=" + IssueDate +
                ", ReturnDate=" + ReturnDate +
                ", Status='" + Status + '\'' +
                '}';
    }
}
