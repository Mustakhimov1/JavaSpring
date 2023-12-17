package com.auto.dealership.controller;

import com.auto.dealership.dto.UserDto;
import com.auto.dealership.dto.UserRegistrationDtoRequest;
import com.auto.dealership.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping ("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("dto", new UserRegistrationDtoRequest());
        return "registration";

    }

    @PostMapping (value = "/registration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String registration(@Valid UserRegistrationDtoRequest dto) {
        authService.registration(dto);
        return "redirect:/";
    }
}
