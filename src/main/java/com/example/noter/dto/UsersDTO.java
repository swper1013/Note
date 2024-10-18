package com.example.noter.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Data
public class UsersDTO {
    private Long usernum;
    private String userid;
    private String password;
    private String name;
    private String email;
    private LocalDate createdAt;

    //권한여부
    private String permission;




}
