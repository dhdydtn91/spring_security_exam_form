package com.springsecurity.demo.config.auth;

import com.springsecurity.demo.model.User;
import com.springsecurity.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//시큐리티 설정에서 loginProcessingUrl("/login");
//login 요청이 오면 자동으로 UserDetailsservice 타입으로 IOC되어 있는 loadUserByUsername 함수가 실행
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userEntity = userRepository.findByUsername(username);
        return new PrincipalDetails(userEntity.orElse(null));
    }
}
