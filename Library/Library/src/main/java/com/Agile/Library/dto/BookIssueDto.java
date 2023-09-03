package com.Agile.Library.dto;

import java.util.Date;

public class BookIssueDto {
    private Date IssueDate;

    private Date ReturnDate;

    private String Status;

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

    public BookIssueDto(Date issueDate, Date returnDate, String status) {
        IssueDate = issueDate;
        ReturnDate = returnDate;
        Status = status;
    }

    public BookIssueDto() {
    }

    @Override
    public String toString() {
        return "BookIssueDto{" +
                "IssueDate=" + IssueDate +
                ", ReturnDate=" + ReturnDate +
                ", Status='" + Status + '\'' +
                '}';
    }
}
