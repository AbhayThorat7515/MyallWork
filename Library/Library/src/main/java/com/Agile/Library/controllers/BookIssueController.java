package com.Agile.Library.controllers;


import com.Agile.Library.dto.BookIssueDto;
import com.Agile.Library.services.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookIssueController {
    @Autowired
    private BookIssueService bookIssueService;

    @RequestMapping(value = "/addBookIssu", method = RequestMethod.POST)
    public ResponseEntity<?> addBookIssu(@RequestBody BookIssueDto bookIssueDto)
    {
        bookIssueService.addBookIssu(bookIssueDto);
        return ResponseEntity.ok().body("");
    }
}
