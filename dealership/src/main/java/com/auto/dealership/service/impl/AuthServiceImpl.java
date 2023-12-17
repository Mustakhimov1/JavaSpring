package com.auto.dealership.service.impl;

import com.auto.dealership.dto.UserDto;
import com.auto.dealership.dto.UserRegistrationDtoRequest;
import com.auto.dealership.exception.HttpStatusException;
import com.auto.dealership.model.auth.Role;
import com.auto.dealership.model.auth.User;
import com.auto.dealership.repository.UserRepository;
import com.auto.dealership.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDto registration(UserRegistrationDtoRequest dto) {
        if (!dto.getPassword().equals(dto.getRePassword())) {
            throw new HttpStatusException("Passwords must be the same");
        }

        userRepository.findByUsername(dto.getUsername())
                .ifPresent(user -> {
                    throw new HttpStatusException(String.format("User %s is already exists", dto.getUsername()));
                });

        User user = new User(dto.getUsername(), passwordEncoder.encode(dto.getPassword()), Role.USER);
        user = userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());

        return userDto;
    }
}
