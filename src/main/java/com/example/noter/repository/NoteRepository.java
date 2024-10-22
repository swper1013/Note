package com.example.noter.repository;

import com.example.noter.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteEntity,Long> {
}
