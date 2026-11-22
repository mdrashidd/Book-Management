package com.example.rashid.Book.Manangment.Service;

import com.example.rashid.Book.Manangment.Entity.Book;
import com.example.rashid.Book.Manangment.Repository.BookRepository;
import com.example.rashid.Book.Manangment.dto.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;

    public BookService(ModelMapper modelMapper, BookRepository bookRepository) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBook() {
        List<Book> book = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(Book b : book){
            bookDTOS.add(modelMapper.map(b,BookDTO.class));
        }
        return bookDTOS;
    }

    public BookDTO getBookById(Long id) {
        return modelMapper.map(bookRepository.findById(id),BookDTO.class);
    }

    public List<BookDTO> getBookByAuthor(String author) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        for( Book b :bookRepository.findByAuthor(author) )
        bookDTOS.add(modelMapper.map(b,BookDTO.class));
        return bookDTOS;
    }


    public BookDTO save(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO,Book.class);
        Book bookSave = bookRepository.save(book);
        return modelMapper.map(bookSave, BookDTO.class);
    }

    public boolean deleteById(Long id) {
        bookRepository.deleteById(id);
        return bookRepository.existsById(id);
    }

    public BookDTO findByTitle(String title) {
        return modelMapper.map(bookRepository.findByTitle(title), BookDTO.class);
    }

    public List<BookDTO> findByPublishedOnAfter(LocalDateTime publishedAfter) {
        List<Book> books = bookRepository.findByPublishedOnAfter(publishedAfter);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(Book b : books){
            bookDTOS.add(modelMapper.map(b, BookDTO.class));
        }
        return bookDTOS;
    }
}
