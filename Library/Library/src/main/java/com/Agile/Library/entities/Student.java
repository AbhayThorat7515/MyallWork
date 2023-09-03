package com.Agile.Library.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "stud_name" , nullable = false)
    private String stud_name;


    //add student into Bookissue

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER, mappedBy = "id")
    private List<BookIssue>b_issue_no;

    public List<BookIssue> getB_issue_no() {
        return b_issue_no;
    }
    ////


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stud_name='" + stud_name + '\'' +
                ", b_issue_no=" + b_issue_no +
                '}';
    }
}