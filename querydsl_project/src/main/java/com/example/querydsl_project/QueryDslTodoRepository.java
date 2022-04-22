package com.example.querydsl_project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryDslTodoRepository extends JpaRepository<TodoEntity,Integer>, QueryDslTodoCustomRepository {

}
