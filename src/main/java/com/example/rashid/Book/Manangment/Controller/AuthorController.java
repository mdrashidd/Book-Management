package com.example.rashid.Book.Manangment.Controller;


import com.example.rashid.Book.Manangment.Service.AuthorService;
import com.example.rashid.Book.Manangment.dto.AuthorDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {

   private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping()
    public AuthorDTO save(@RequestBody AuthorDTO authorDTO){
        return authorService.save(authorDTO);
    }

    @GetMapping()
    public List<AuthorDTO> findAll(){
       return authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDTO findById(@PathVariable(name = "id") long id){
        return authorService.findById(id);
    }

    @PatchMapping("/{id}")
    public AuthorDTO patch(@PathVariable(name = "id") long id, @RequestBody Map<String,Object> updates){
        AuthorDTO authorDTO = findById(id);
        if(updates.containsKey("id"))
            authorDTO.setId((Long) updates.get("id"));
        if(updates.containsKey("name"))
            authorDTO.setName((String) updates.get("name"));

        return save(authorDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAuthor(@PathVariable(name = "id") Long id){
        if(findById(id) == null) return false;
        return authorService.delete(id);
    }


}
