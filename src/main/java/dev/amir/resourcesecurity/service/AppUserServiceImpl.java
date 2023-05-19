package dev.amir.resourcesecurity.service;

import dev.amir.resourcesecurity.dto.CreateUserDto;
import dev.amir.resourcesecurity.dto.MessageDto;
import dev.amir.resourcesecurity.entity.Role;
import dev.amir.resourcesecurity.entity.RoleName;
import dev.amir.resourcesecurity.entity.User;
import dev.amir.resourcesecurity.repository.RoleRepository;
import dev.amir.resourcesecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MessageDto createUser(CreateUserDto createUserDto) {
        User user = User.builder()
                .username(createUserDto.username())
                .password(passwordEncoder.encode(createUserDto.password()))
                .build();
        Set<Role> roles = new HashSet<>();
        createUserDto.roles().forEach(
                role -> roleRepository.findByName(RoleName.valueOf(role))
                        .ifPresentOrElse(roles::add, () -> {
                            throw new RuntimeException("Role not found");
                        })
        );
        user.setRoles(roles);
        userRepository.save(user);
        return new MessageDto("User " + user.getUsername() + " created successfully");
    }
}
