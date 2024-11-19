package com.example.noter.service;

import com.example.noter.dto.NoteDTO;
import com.example.noter.entity.NoteEntity;
import com.example.noter.entity.UsersEntity;
import com.example.noter.repository.NoteRepository;
import com.example.noter.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Log4j2
@Transactional

public class NoteServiceImpl implements NoteService {
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public boolean register(NoteDTO noteDTO, String userid) {
        Optional<UsersEntity> usersEntity =userRepository.findByUserid(userid);
        log.info(userid);
        NoteEntity noteEntity = new NoteEntity();
        UsersEntity usersEntity1 = usersEntity.get();
        //노트엔티티가 널일때
        if (noteEntity == null){
            noteEntity = modelMapper.map(noteDTO,NoteEntity.class);
            //데이트가 널이 아닐떄?
            if(noteEntity.getLocalDate()!=null){
                log.info("그 로컬데이트 널아냐");
                noteRepository.save(noteEntity);
                noteEntity.setUsersEntity(usersEntity1);
                return true;
            }
            else {
                log.info("그 로컬데이트 널이야");
                noteEntity.setLocalDate(LocalDate.now());
                noteRepository.save(noteEntity);
                noteEntity.setUsersEntity(usersEntity1);
                return true;
            }
        }else {
            log.info("저장불가일세");
            return false;
        }
       
    }

    @Override
    public List<NoteDTO> seletAll() {
        return null;
    }

    @Override
    public Long delete(Long num) {
        return null;
    }
}
