package com.example.springdatajpa_project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaTodoRepository extends JpaRepository<TodoEntity,Integer> {
    List<TodoEntity> findAllByDeleteYn(String deleteYn);
    TodoEntity findByIdxAndDeleteYn(Integer idx, String deleteYn);
}