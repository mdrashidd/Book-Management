package com.example.rashid.Book.Manangment.Controller;

import com.example.rashid.Book.Manangment.Service.BookService;
import com.example.rashid.Book.Manangment.dto.BookDTO;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<BookDTO> getAllBooks(){
        return  bookService.getAllBook();
    }


    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable(name = "id") long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/author")
    public List<BookDTO> getBookByAuthor(@PathVariable(name = "author") String author){
        return bookService.getBookByAuthor(author);
    }

    @PostMapping
    public BookDTO createNewBook(@RequestBody BookDTO bookDTO ){
        return bookService.save(bookDTO);
    }

    @PatchMapping("/{id}")
    public BookDTO patchBook(@PathVariable(name = "id") long id, @RequestBody Map<String,Object> updates){
        BookDTO bookDTO = getBookById(id);

        if(updates.containsKey("id"))
            bookDTO.setId((Long) updates.get("id"));
        if(updates.containsKey("title"))
            bookDTO.setTitle((String) updates.get("title"));
        if(updates.containsKey("theme"))
            bookDTO.setTheme((String) updates.get("theme"));
        if(updates.containsKey("publishedOn"))
            bookDTO.setPublishedOn((LocalDateTime) updates.get("publishedOn"));

        return bookService.save(bookDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable(name = "id") Long id){
        return bookService.deleteById(id);
    }

    @GetMapping("/{title}")
    public BookDTO findBookByTitle(@PathVariable(name = "title") String title){
        return bookService.findByTitle(title);
    }

    @GetMapping("{publishedAfter}")
    public List<BookDTO> findByPublishedOnAfter(@PathVariable(name = "publishedAfter") LocalDateTime publishedAfter){
        return bookService.findByPublishedOnAfter(publishedAfter);
    }

}
