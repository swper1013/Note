package com.example.noter.service;

import com.example.noter.dto.UsersDTO;
import com.example.noter.entity.UsersEntity;
import com.example.noter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2

public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();
    private final UserRepository userRepository;
    @Override
    public Long register(UsersDTO usersDTO) {
        log.info("DTO Values - UserID: {}, Password: {}, Email: {}", usersDTO.getUserid(), usersDTO.getPassword(), usersDTO.getEmail());

        // 비밀번호 암호화
       String encrypt = passwordEncoder.encode(usersDTO.getPassword());
        usersDTO.setPassword(encrypt);

        // DTO -> Entity 변환 (usernum은 매핑에서 제외)
        UsersEntity usersEntity = modelMapper.map(usersDTO, UsersEntity.class);
        usersEntity.setPassword(encrypt); // 암호화된 비밀번호를 엔티티에 직접 설정

        // DB에 저장
        UsersEntity savedUser = userRepository.save(usersEntity);

        // 저장된 엔티티의 usernum 반환
        return savedUser.getUsernum();
    }


    @Override
    public boolean checkId(String userid) {
        return false;
    }
    @Override
    public  boolean checkPassword(String password){
        return false;
    }

    @Override
    public UsersDTO updateUser(String userid, UsersDTO usersDTO) {
        return null;
    }

    @Override
    public UsersDTO getUser(String userid) {
        return null;
    }
}
