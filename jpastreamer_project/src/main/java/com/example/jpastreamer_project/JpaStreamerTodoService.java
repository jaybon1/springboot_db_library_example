package com.example.jpastreamer_project;

import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JpaStreamerTodoService {

    private final JpaStreamerTodoRepository jpaStreamerTodoRepository;

    private final JPAStreamer jpaStreamer;

    public List<TodoEntity> findAll() {

        List<TodoEntity> n = jpaStreamer.stream(TodoEntity.class)
                .filter(TodoEntity$.deleteYn.equal("N"))
                .collect(Collectors.toList());

        return n;

    }

    @Transactional
    public void insert(List<String> stringList) {
        stringList.forEach(content -> {
            TodoEntity todoEntity = TodoEntity.builder()
                    .content(content)
                    .doneYn("N")
                    .deleteYn("N")
                    .createDate(LocalDateTime.now())
                    .build();

            jpaStreamerTodoRepository.save(todoEntity);

        });
    }

    @Transactional
    public void changeDone(List<Integer> idxList) {
        idxList.forEach(idx -> {

            Optional<TodoEntity> todoEntityOptional = jpaStreamerTodoRepository.findByIdxAndDeleteYn(idx, "N");

//            Optional<TodoEntity> todoEntityOptional =
//                    jpaStreamer.stream(TodoEntity.class)
//                            .filter(TodoEntity$.idx.equal(idx))
//                            .filter(TodoEntity$.deleteYn.equal("N"))
//                            .findFirst();

            todoEntityOptional.ifPresent(todoEntity -> {
                todoEntity.setDoneYn("Y".equals(todoEntity.getDoneYn()) ? "N" : "Y");
                todoEntity.setUpdateDate(LocalDateTime.now());
            });

        });
    }

    @Transactional
    public void delete(List<Integer> idxList) {
        idxList.forEach(idx -> {

            Optional<TodoEntity> todoEntityOptional = jpaStreamerTodoRepository.findByIdxAndDeleteYn(idx, "N");

//            Optional<TodoEntity> todoEntityOptional =
//                    jpaStreamer.stream(TodoEntity.class)
//                            .filter(TodoEntity$.idx.equal(idx))
//                            .filter(TodoEntity$.deleteYn.equal("N"))
//                            .findFirst();

            todoEntityOptional.ifPresent(todoEntity -> {
                todoEntity.setDeleteYn("Y");
                todoEntity.setDeleteDate(LocalDateTime.now());
            });

        });
    }

}
