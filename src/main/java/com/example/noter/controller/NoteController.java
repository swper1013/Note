package com.example.noter.controller;

import com.example.noter.dto.NoteDTO;
import com.example.noter.dto.UsersDTO;
import com.example.noter.service.NoteService;
import com.example.noter.service.NoteServiceImpl;
import com.example.noter.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@Log4j2
@RequiredArgsConstructor

public class NoteController {
    private final UserService userService;
    private final NoteService noteService;



    @RequestMapping("/")
    public String note(){
        return "/hello";
    }
    @GetMapping ("/note")
    public String notemain(Model model){
        model.addAttribute("NoteDTO",new NoteDTO());
        return "main";
    }
    @GetMapping ("/forgotpass")
    public String forgotpass(){
        return "forgotpass";
    }
    @GetMapping("/note/register")
    public void registerPost(NoteDTO noteDTO){

    }
    @PostMapping("/note/register")
    public String register(@ModelAttribute NoteDTO noteDTO, BindingResult bindingResult, Model model, Principal principal){
        UsersDTO usersDTO = userService.getUser(principal.getName());
        model.addAttribute("NoteDTO", new NoteDTO());
        if (bindingResult.hasErrors()){
            log.info("에러에러에러"+bindingResult.getAllErrors());
            return "main";
        }
    return "main";

    }




}
