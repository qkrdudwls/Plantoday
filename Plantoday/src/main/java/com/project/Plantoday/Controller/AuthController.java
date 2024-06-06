package com.project.Plantoday.Controller;

import com.project.Plantoday.DTO.UserDTO;
import com.project.Plantoday.Service.AuthService;
import com.project.Plantoday.exception.InvalidCredentialsException;
import com.project.Plantoday.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public String register(@ModelAttribute UserDTO userDTO, Model model) {
        try {
            authService.register(userDTO);
            model.addAttribute("successMessage", "User registered successfully");
            return "login";
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, Model model) {
        try {
            authService.login(userDTO.getUsername(), userDTO.getPassword());
            return "redirect:/home";
        } catch (InvalidCredentialsException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "login";
    }
/*
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        try {
            authService.register(userDTO);
            return ResponseEntity.ok("User registered successfully");
        }catch(UserAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        try {
            authService.login(userDTO.getUsername(), userDTO.getPassword());
            return ResponseEntity.ok("User logged in successfully");
        } catch (InvalidCredentialsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
*/
}