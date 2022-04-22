package com.example.mybatis_project;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "idx", callSuper = false)
public class TodoEntity {


    private Integer idx;

    private String content;

    private String doneYn;

    private String deleteYn;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private LocalDateTime deleteDate;

}
