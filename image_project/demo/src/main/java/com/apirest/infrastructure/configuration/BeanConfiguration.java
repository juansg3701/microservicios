package com.apirest.infrastructure.configuration;

import com.apirest.application.mapper.impl.ImageDtoMapperImpl;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ImageDtoMapperImpl imageDtoMapperImpl(){
        return new ImageDtoMapperImpl();
    }

}
