package com.project.Plantoday.Controller;

import com.project.Plantoday.DTO.UserDTO;
import com.project.Plantoday.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        authService.register(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        authService.login(userDTO.getUsername(),userDTO.getPassword());
        return "redirect:/home";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}