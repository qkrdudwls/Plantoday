package com.project.Plantoday.Security;

import com.project.Plantoday.Entity.User;
import com.project.Plantoday.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user=userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).authorities("USER").accountExpired(false).accountLocked(false).credentialsExpired(false).disabled(false).build();
    }
}
