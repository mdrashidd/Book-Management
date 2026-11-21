package com.example.rashid.Book.Manangment.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorDTO {
    private long id;
    private String name;
}
