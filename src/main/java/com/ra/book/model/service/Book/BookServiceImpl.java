package com.ra.book.model.service.Book;

import com.ra.book.model.dao.Book.BookDAO;
import com.ra.book.model.entity.Book;
import com.ra.book.model.entity.Category;
import com.ra.book.model.entity.dto.BookDTO;
import com.ra.book.model.service.UploadFile.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static sun.applet.AppletResourceLoader.getImage;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private UploadFileService uploadFileService;
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Boolean create(BookDTO book) {
        String image = "";
        if (book.getImage() != null) {
             image = uploadFileService.uploadFile(book.getImage());
            System.out.println(image);
        }
//        upload file
        
//        convert
        Book bookEntity = new Book();
        bookEntity.setName(book.getName());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setImage(image);
        bookEntity.setDescription(book.getDescription());
        bookEntity.setStatus(book.isStatus());
        bookEntity.setCategory(book.getCategory());

        return bookDAO.create(bookEntity);
    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }



    @Override
    public Boolean update(Book book) {
        return bookDAO.update(book);
    }

    @Override
    public void delete(int id) {
    bookDAO.delete(id);
    }
}
