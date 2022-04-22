package com.example.querydsl_project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryDslTodoService {

    private final QueryDslTodoRepository queryDslTodoRepository;

    public List<TodoEntity> findAll() {
        return queryDslTodoRepository.findAllByDeleteYn("N");
    }

    @Transactional
    public void insert(List<String> stringList){
        stringList.forEach(content -> {
            TodoEntity todoEntity = TodoEntity.builder()
                    .content(content)
                    .doneYn("N")
                    .deleteYn("N")
                    .createDate(LocalDateTime.now())
                    .build();
            queryDslTodoRepository.save(todoEntity);
        });
    }

    @Transactional
    public void changeDone(List<Integer> idxList){
        idxList.forEach(idx -> {
            TodoEntity todoEntity = queryDslTodoRepository.findByIdxAndDeleteYn(idx, "N");
            todoEntity.setDoneYn("Y".equals(todoEntity.getDoneYn())? "N" : "Y");
            todoEntity.setUpdateDate(LocalDateTime.now());
        });
    }

    @Transactional
    public void delete(List<Integer> idxList){
        idxList.forEach(idx -> {
            TodoEntity todoEntity = queryDslTodoRepository.findByIdxAndDeleteYn(idx, "N");
            todoEntity.setDeleteYn("Y");
            todoEntity.setDeleteDate(LocalDateTime.now());
        });
    }
}
