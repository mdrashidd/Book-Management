package com.example.rashid.Book.Manangment.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private long id;
    private String title;
    private String theme;
    private LocalDateTime publishedOn;
}

