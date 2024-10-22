package com.example.noter.controller;

import com.example.noter.dto.UsersDTO;
import com.example.noter.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private final UserService userService;
    @GetMapping("/signpage")
    public String SignUp(Model model) {
        UsersDTO usersDTO = new UsersDTO(); // 사용자 DTO 생성
        model.addAttribute("usersDTO", usersDTO); // 모델에 추가
        return "signpage"; // Thymeleaf 템플릿 이름 반환
    }
    @PostMapping("/signpage")
    public String register(@Valid UsersDTO usersDTO, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            log.error("에러입니다 : {}",bindingResult.getAllErrors());
            model.addAttribute("errorMessage", "입력한 데이터에 오류가 있습니다.");
            return "signpage";
        }
        log.info(usersDTO);
        userService.register(usersDTO);


        return "redirect:";
    }

    @GetMapping("/login")
    public String login(HttpServletResponse response) throws IOException{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//인증된 사용자 정보가져오기
        if (authentication !=null&& authentication.isAuthenticated() &&!(authentication instanceof AnonymousAuthenticationToken)){
            response.sendRedirect("/note");
            return null;
        }
        return "note";
    }

}
