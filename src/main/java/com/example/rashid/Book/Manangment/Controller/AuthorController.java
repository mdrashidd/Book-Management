package com.example.rashid.Book.Manangment.Controller;


import com.example.rashid.Book.Manangment.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorDTO authorDTO;

    @PostMapping()
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO){
        return authorDTO;
    }

    @GetMapping()
    public List<AuthorDTO> getAllAuthor(){
        List<AuthorDTO> authors = new ArrayList<>();
        authors.add(new AuthorDTO(1,"James Bond"));
        authors.add( new AuthorDTO(2,"APJ Abdul Kalam"));
        return authors;
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable(name = "id") long id){
        return new AuthorDTO(id,"Rashid");
    }

    @PatchMapping("/{id}")
    public AuthorDTO patchAuthor(@PathVariable(name = "id") long id, @RequestBody Map<String,Object> updates){
        AuthorDTO authorDTO = new AuthorDTO(1,"James Bond");
        if(updates.containsKey("id"))
            authorDTO.setId((Long) updates.get("id"));
        if(updates.containsKey("name"))
            authorDTO.setName((String) updates.get("name"));

        return authorDTO;
    }

    @PutMapping("/{id}")
    public boolean deleteAuthor(@PathVariable(name = "id") Long id){
        return true;
    }


}
