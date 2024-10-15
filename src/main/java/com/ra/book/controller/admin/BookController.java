package com.ra.book.controller.admin;

import com.ra.book.model.entity.Book;
import com.ra.book.model.entity.Category;
import com.ra.book.model.entity.dto.BookDTO;
import com.ra.book.model.entity.dto.CategoryDTO;
import com.ra.book.model.service.Book.BookService;
import com.ra.book.model.service.Category.CategoryService;
import com.ra.book.model.service.UploadFile.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/book")
public class BookController {
    public static String oldNameBook = "";
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UploadFileService uploadService;

    @GetMapping
    public String index(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "admin/book/index";
    }
    @GetMapping("/add")
    public String add(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new BookDTO());
        return "admin/book/add";
    }
    @PostMapping("/add")
    public String create( @Valid @ModelAttribute("book") BookDTO bookDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("book", bookDTO);
            return "admin/book/add";
        } else {
            if(bookService.create(bookDTO)){
                return "redirect:/admin/book";
            }
            return "redirect:/admin/book/add";
        }

    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Book book = bookService.findById(id);
        List<Category> categories = categoryService.findAll();

        BookDTO bookDTO = new BookDTO();
        bookDTO.setName(book.getName());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setPrice(book.getPrice());

        bookDTO.setDescription(book.getDescription());
        bookDTO.setStatus(book.isStatus());
        bookDTO.setCategory(book.getCategory());

        model.addAttribute("bookDTO", bookDTO);
        model.addAttribute("categories", categories);
        model.addAttribute("book", book);
        return "admin/book/edit";
    }
    @PostMapping("/edit/{id}")
    public String update( @Valid @ModelAttribute("bookDTO") BookDTO bookDTO,
//                          @ModelAttribute("book") Book book,
                          BindingResult result,
                          @PathVariable int id,
                          Model model) {
        if(result.hasErrors()) {
            List<Category> categories = categoryService.findAll();
            model.addAttribute("bookDTO", bookDTO);
            model.addAttribute("categories", categories);
            return "admin/book/edit";
        }
        Book bookEntity = bookService.findById(id);
        bookEntity.setName(bookDTO.getName());
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setPublisher(bookDTO.getPublisher());
        bookEntity.setPrice(bookDTO.getPrice());
        bookEntity.setDescription(bookDTO.getDescription());
        bookEntity.setStatus(bookDTO.isStatus());
        bookEntity.setCategory(bookDTO.getCategory());
        if (bookDTO.getImage() != null) {
            String bookImage = uploadService.uploadFile (bookDTO.getImage());
            bookEntity.setImage (bookImage);
        }

        if(bookService.update(bookEntity)){
            return "redirect:/admin/book";
        }
        return "redirect:/admin/book/edit" + id;
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        bookService.delete(id);
        return "redirect:/admin/book";
    }
}
