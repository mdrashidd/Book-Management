package com.example.rashid.Book.Manangment.Configure;

import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
public class MapperCong {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
