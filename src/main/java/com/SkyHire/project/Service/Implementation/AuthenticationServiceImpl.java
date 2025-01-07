package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.Role;
import com.SkyHire.project.Entity.UserDTO;
import com.SkyHire.project.Entity.UserEntity;
import com.SkyHire.project.Repository.UserRepo;
import com.SkyHire.project.Service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final UserDTO userDTO;
    private final PasswordEncoder passwordEncoder;



    @Override
    public void register(UserEntity user) {

        user.setRole(Role.CUSTOMER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

    }

    @Override
    public UserDTO login(UserEntity user) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));

       UserEntity userEntity= userRepo.findByEmail(user.getEmail()).orElseThrow();

       return userDTO.converToDTO(userEntity);
    }
}
