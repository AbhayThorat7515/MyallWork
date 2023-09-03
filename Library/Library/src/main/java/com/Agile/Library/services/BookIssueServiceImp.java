package com.Agile.Library.services;

import com.Agile.Library.dto.BookIssueDto;
import com.Agile.Library.entities.BookIssue;
import com.Agile.Library.repositories.BookIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookIssueServiceImp implements BookIssueService{

    @Autowired
    private BookIssueRepository bookIssueRepository;

    @Override
    public void addBookIssu(BookIssueDto bookIssueDto) {
        try {
            BookIssue bookIssue = new BookIssue();
            bookIssue.setIssueDate(bookIssueDto.getIssueDate());
            bookIssue.setReturnDate(bookIssueDto.getReturnDate());
            bookIssue.setStatus(bookIssueDto.getStatus());
            bookIssueRepository.save(bookIssue);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
