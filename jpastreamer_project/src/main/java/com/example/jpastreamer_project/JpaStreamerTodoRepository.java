package com.example.jpastreamer_project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaStreamerTodoRepository extends JpaRepository<TodoEntity,Integer> {

    Optional<TodoEntity> findByIdxAndDeleteYn(Integer idx, String deleteYn);
    List<TodoEntity> findByDeleteYn(String deleteYn);

}
