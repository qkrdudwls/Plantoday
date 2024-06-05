package com.project.Plantoday.Service;

import com.project.Plantoday.DTO.UserDTO;
import com.project.Plantoday.Entity.User;
import com.project.Plantoday.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public void register(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setJoinedAt(LocalDateTime.now());
        userRepository.saveAndFlush(user);
    }

   public void login(String username, String password) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
   }
}