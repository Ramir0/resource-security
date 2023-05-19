package dev.amir.resourcesecurity.repository;

import dev.amir.resourcesecurity.entity.Role;
import dev.amir.resourcesecurity.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
