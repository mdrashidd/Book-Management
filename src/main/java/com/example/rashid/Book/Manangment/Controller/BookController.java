package com.example.rashid.Book.Manangment.Controller;

import com.example.rashid.Book.Manangment.dto.AuthorDTO;
import com.example.rashid.Book.Manangment.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookDTO bookDTO;

    @GetMapping()
    public BookDTO getBook() {
        return new BookDTO(1,"White Nights","Classis", LocalDateTime.of(2000,12,02,20,20));
    }

    @GetMapping()
    public List<BookDTO> getAllBooks(){
        List<BookDTO> authors = new ArrayList<>();
        authors.add(new BookDTO(1,"White Nights","Classis", LocalDateTime.of(2000,12,02,20,20)));
        authors.add( new BookDTO(1,"White Nights","Classis", LocalDateTime.of(2000,12,02,20,20)));
        return authors;
    }


    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable(name = "id") long id){
        return new BookDTO(1,"White Nights","Classis", LocalDateTime.of(2000,12,02,20,20));
    }

    @GetMapping("/author")
    public BookDTO getBookByAuthor(@PathVariable(name = "author") String author){
        return new BookDTO(1,"White Nights","Classis", LocalDateTime.of(2000,12,02,20,20));
    }

    @PostMapping
    public BookDTO createNewBook(@RequestBody BookDTO bookDTO ){
        return bookDTO;
    }

    @PatchMapping("/{id}")
    public BookDTO patchBook(@PathVariable(name = "id") long id, @RequestBody Map<String,Object> updates){
        BookDTO bookDTO = new BookDTO(1,"White Nights","Classis", LocalDateTime.of(2000,12,02,20,20));

        if(updates.containsKey("id"))
            bookDTO.setId((Long) updates.get("id"));
        if(updates.containsKey("title"))
            bookDTO.setTitle((String) updates.get("title"));
        if(updates.containsKey("theme"))
            bookDTO.setTheme((String) updates.get("theme"));
        if(updates.containsKey("publishedOn"))
            bookDTO.setPublishedOn((LocalDateTime) updates.get("publishedOn"));

        return bookDTO;
    }

    @PutMapping("/{id}")
    public boolean deleteBook(@PathVariable(name = "id") Long id){
        return true;
    }

    @GetMapping("/{title}")
    public BookDTO findBookByTitle(@PathVariable(name = "title") String title){
        return new BookDTO(1,title,"Classis", LocalDateTime.of(2000,12,02,20,20));
    }

    @GetMapping("{publishedAfter}")
    public List<BookDTO> getAllBookPublishedAfter(@PathVariable(name = "publishedAfter") LocalDateTime publishedAfter){
        List<BookDTO> authors = new ArrayList<>();
        authors.add(new BookDTO(1,"White Nights","Classis", LocalDateTime.of(2000,12,02,20,20)));
        authors.add( new BookDTO(1,"White Nights","Classis", LocalDateTime.of(2020,12,02,20,20)));
        return authors;
    }

}
