package com.example.noter.service;

import com.example.noter.dto.NoteDTO;

import java.util.List;

public interface NoteService {
    public boolean register(NoteDTO noteDTO, String userid);
    public List<NoteDTO>seletAll();
    public Long delete(Long num);
}
