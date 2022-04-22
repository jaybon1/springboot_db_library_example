package com.example.querydsl_project;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class JpaConfig {

    private final EntityManager em;

    @Bean
    public JPAQueryFactory jPAQueryFactory() {
        return new JPAQueryFactory(em);
    }

}