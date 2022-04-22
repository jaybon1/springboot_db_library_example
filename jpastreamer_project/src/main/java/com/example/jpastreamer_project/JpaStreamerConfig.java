package com.example.jpastreamer_project;

import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class JpaStreamerConfig {

    private final EntityManager entityManager;

    @Bean
    public JPAStreamer jpaStreamer() {
        return JPAStreamer.of(entityManager.getEntityManagerFactory());
    }

}
