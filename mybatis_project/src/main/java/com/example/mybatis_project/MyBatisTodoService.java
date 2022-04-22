package com.example.mybatis_project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyBatisTodoService {

    private final MyBatisTodoRepository myBatisTodoRepository;

    public List<TodoEntity> findAll() {
        return myBatisTodoRepository.findAll();
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
            myBatisTodoRepository.insert(todoEntity);
        });
    }

    @Transactional
    public void changeDone(List<Integer> idxList){
        idxList.forEach(idx -> {
            TodoEntity todoEntity = myBatisTodoRepository.findByIdx(idx);
            todoEntity.setDoneYn("Y".equals(todoEntity.getDoneYn())? "N" : "Y");
            todoEntity.setUpdateDate(LocalDateTime.now());
            myBatisTodoRepository.update(todoEntity);
        });
    }

    @Transactional
    public void delete(List<Integer> idxList){
        idxList.forEach(idx -> {
            TodoEntity todoEntity = myBatisTodoRepository.findByIdx(idx);
            todoEntity.setDeleteYn("Y");
            todoEntity.setDeleteDate(LocalDateTime.now());
            myBatisTodoRepository.update(todoEntity);
        });
    }

}
