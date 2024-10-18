package com.example.noter.users;

import com.example.noter.dto.UsersDTO;
import com.example.noter.entity.UsersEntity;
import com.example.noter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j2
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();


    //로그인 처리 서비스
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //아이디 없다?
       UsersEntity usersEntity = this.userRepository.findByUserid(username)
               .orElseThrow(()->new UsernameNotFoundException("아이디를 찾을 수 없습니다."));
        UsersDTO usersDTO = modelMapper.map(usersEntity,UsersDTO.class);

        //계정별 세션정보 리스트
        List<GrantedAuthority> authorityList = new ArrayList<>();
        if("ADMIN".equals(usersDTO.getPermission().toString().trim())){
            authorityList.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        }else {
            authorityList.add(new SimpleGrantedAuthority(UserRole.USER.getValue()
            ));
        }
        return  new User(usersDTO.getUserid(),usersDTO.getPassword(),authorityList);
    }
}
