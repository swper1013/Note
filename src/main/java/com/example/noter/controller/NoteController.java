package com.example.noter.controller;

import com.example.noter.dto.UsersDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor

public class NoteController {


    @RequestMapping("/")
    public String note(){
        return "/hello";
    }
    @GetMapping ("/note")
    public String notemain(){
        return "main";
    }
    @GetMapping ("/forgotpass")
    public String forgotpass(){
        return "forgotpass";
    }




}
