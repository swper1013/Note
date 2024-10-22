package com.example.noter.service;

import com.example.noter.dto.UsersDTO;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    Long register(UsersDTO usersDTO);
    boolean checkId(String userid);
    boolean checkPassword(String password);
    UsersDTO updateUser(String userid, UsersDTO usersDTO);
    UsersDTO getUser(String userid);
}
