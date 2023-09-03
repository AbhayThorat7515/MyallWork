package com.Agile.Library.controllers;


import com.Agile.Library.dto.BookDto;
import com.Agile.Library.entities.Book;
import com.Agile.Library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    //Add Book
@Autowired
private BookService bookService;

//Add Book
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto)
    {
        bookService.addBook(bookDto);
        return ResponseEntity.ok().body("");
    }

    //getbook

    @RequestMapping(value = "/getBook", method = RequestMethod.GET)
    public List<Book>getBook()
    {
        return this.bookService.getAllBook();
    }


    @DeleteMapping("/deleteBook/{bid}")
    public void deleteBook(@PathVariable("bid") Long bid) {
        bookService.deleteById(bid);
    }

    //Update quantity
    @PutMapping("/booksUpdate")
    private Book saveOrUpdate(@RequestBody Book quantity)
    {
        bookService.saveOrUpdate(quantity);
        return quantity;
    }

}

