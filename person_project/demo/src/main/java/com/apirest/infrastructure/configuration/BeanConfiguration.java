package com.apirest.infrastructure.configuration;

import com.apirest.application.mapper.impl.PersonDtoMapperImpl;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PersonDtoMapperImpl personDtoMapperImpl(){
        return new PersonDtoMapperImpl();
    }

}
