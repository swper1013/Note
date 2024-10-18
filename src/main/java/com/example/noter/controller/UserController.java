package com.example.noter.controller;

import com.example.noter.dto.UsersDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class UserController {
    @GetMapping("/signpage")
    public String SignUp(Model model) {
        UsersDTO usersDTO = new UsersDTO(); // 사용자 DTO 생성
        model.addAttribute("usersDTO", usersDTO); // 모델에 추가
        return "signpage"; // Thymeleaf 템플릿 이름 반환
    }
}
