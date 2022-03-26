package com.kibuh.tstestexo2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TsTestExo2Application {

    public static void main(String[] args) {
        SpringApplication.run(TsTestExo2Application.class, args);
    }




    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*")
                        .allowedOrigins("*")
                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials","UserID","Authorization")
                        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method","authorization");

            }
        };
    }

}
