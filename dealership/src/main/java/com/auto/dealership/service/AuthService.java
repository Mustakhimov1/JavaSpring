package com.auto.dealership.service;

import com.auto.dealership.dto.UserDto;
import com.auto.dealership.dto.UserRegistrationDtoRequest;

public interface AuthService {
    UserDto registration(UserRegistrationDtoRequest dto);
}
