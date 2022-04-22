package com.example.jpastreamer_project;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TODO")
@EqualsAndHashCode(of = "idx", callSuper = false)
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Integer idx;

    @Column(name="content")
    private String content;

    @Column(name="done_yn")
    private String doneYn;

    @Column(name="delete_yn")
    private String deleteYn;

    @Column(name="create_date")
    private LocalDateTime createDate;

    @Column(name="update_date")
    private LocalDateTime updateDate;

    @Column(name="delete_date")
    private LocalDateTime deleteDate;

}
