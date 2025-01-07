package com.SkyHire.project.Repository;

import com.SkyHire.project.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);
}
