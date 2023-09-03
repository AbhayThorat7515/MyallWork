package com.Agile.Library.services;

import com.Agile.Library.dto.BookDto;
import com.Agile.Library.entities.Book;
import com.Agile.Library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImp implements BookService{

   @Autowired
    private  BookRepository bookRepository;

   //add Data
    @Override
    public void addBook(BookDto bookDto) {
    try {
        Book book = new Book();
        book.setBname(bookDto.getBname());
        book.setQuantity(bookDto.getQuantity());
        book.setAvailableBook(bookDto.getAvailableBook());
        bookRepository.save(book);
    }
    catch (Exception e)
    {
         e.printStackTrace();
    }
    }

    //GetData
    @Override
    public List<Book> getAllBook() {

        List<Book> list=this.bookRepository.findAll();
        return list;
    }

    //Delete Book
    @Override
    public void deleteById(Long bid) {
        bookRepository.deleteById(bid);
    }

    //update quantity
    @Override
    public void saveOrUpdate(Book quantity) {
        bookRepository.save(quantity);

    }

}
