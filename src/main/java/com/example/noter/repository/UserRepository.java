package com.example.noter.repository;

import com.example.noter.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersEntity,Long> {
    Optional<UsersEntity> findByUsernum(Long usernum);//유저엔티티 PK값 조회
    Optional<UsersEntity> findByUserid(String userid);//아이디 조회

}


