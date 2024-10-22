package com.example.noter.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class NoteDTO {
    private Long num;//글번호 PK값
    private int listnum;//글순서 번호
    private String title;//제목
    @NotEmpty
    private String content;//내용
    private UsersDTO usersDTO;//유저디티오
    private LocalDate localDate;//작성날짜

}
