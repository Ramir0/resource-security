package dev.amir.resourcesecurity.service;

import dev.amir.resourcesecurity.dto.CreateUserDto;
import dev.amir.resourcesecurity.dto.MessageDto;

public interface AppUserService {
    MessageDto createUser(CreateUserDto createUserDto);
}
