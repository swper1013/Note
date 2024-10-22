package com.example.noter.entity;

import com.example.noter.dto.UsersDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @Column(length = 255)
    private int listnum;
    @Column(length = 50)
    private String title;//제목
    @Column(columnDefinition = "text")
    private String content;//내용
    @Column
    private LocalDate localDate;//작성날짜
    @ManyToOne
    @JoinColumn(name = "usernum")
    private UsersEntity usersEntity;


}
