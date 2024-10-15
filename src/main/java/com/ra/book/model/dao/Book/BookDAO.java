package com.ra.book.model.dao.Book;

import com.ra.book.model.entity.Book;
import com.ra.book.model.entity.dto.BookDTO;

import java.util.List;


public interface BookDAO {
    List<Book> findAll();
    Boolean create(Book book);
    Book findById(int id);
    Boolean update(Book book);
    void delete(int id);
}
