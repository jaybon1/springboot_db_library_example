package com.example.querydsl_project;

import java.util.List;

public interface QueryDslTodoCustomRepository {

    List<TodoEntity> findAllByDeleteYn(String deleteYn);

    TodoEntity findByIdxAndDeleteYn(Integer idx, String deleteYn);

}
