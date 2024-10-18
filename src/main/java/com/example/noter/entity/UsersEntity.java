package com.example.noter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name ="user")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usernum;

    @Column(length = 30,unique = true)
    @Size(min = 2,max = 40, message = "아이디는 2~40자 사이만 가능합니다!")
    @NotEmpty(message = "사용자 아이디는 필수로 작성해주세요!")
    private String userid;

    @Column(length = 254)
    @NotEmpty(message = "사용자 비밀번호는 필수로 작성해주세요!")
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 30)
    @NotEmpty(message = "사용자 이메일은 필수로 작성해주세요!")
    private String email;

    //private String imgUrl;

    private LocalDate createdAt;
}
