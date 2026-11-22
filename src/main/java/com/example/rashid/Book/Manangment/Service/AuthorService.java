package com.example.rashid.Book.Manangment.Service;

import com.example.rashid.Book.Manangment.Entity.Author;
import com.example.rashid.Book.Manangment.Repository.AuthorRepository;
import com.example.rashid.Book.Manangment.dto.AuthorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
   private final ModelMapper modelMapper;
   private final AuthorRepository authorRepository;

   public AuthorService(ModelMapper modelMapper, AuthorRepository authorRepository){
       this.modelMapper = modelMapper;
       this.authorRepository = authorRepository;
   }


    public AuthorDTO save(AuthorDTO authorDTO) {
     return modelMapper.map( authorRepository.save(modelMapper.map(authorDTO, Author.class)) , AuthorDTO.class);
    }

    public List<AuthorDTO> findAll() {
       List<Author> authors = authorRepository.findAll();
       List<AuthorDTO> authorDTOS = new ArrayList<>();
       for(Author a : authors){
           authorDTOS.add(modelMapper.map(a,AuthorDTO.class));
       }
       return authorDTOS;
    }

    public AuthorDTO findById(long id) {
       return modelMapper.map(authorRepository.findById(id),AuthorDTO.class);
    }

    public boolean delete(Long id) {
       authorRepository.deleteById(id);
       return !authorRepository.existsById(id);
    }
}
