package com.Agile.Library.services;

import com.Agile.Library.dto.BookDto;
import com.Agile.Library.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BookService {


    //Add Book
    public void addBook(BookDto bookDto);

    //Get Book
    public List<Book> getAllBook();

    //Delete book
    public void deleteById(Long bid);

    //Update book by quantity
    public void saveOrUpdate(Book quantity);


}
