package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.Role;
import com.SkyHire.project.Entity.UserDTO;
import com.SkyHire.project.Entity.UserEntity;
import com.SkyHire.project.Entity.UserRequestDTO;
import com.SkyHire.project.ExceptionHandle.ResourceNotFoundException;
import com.SkyHire.project.Repository.UserRepo;
import com.SkyHire.project.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final UserDTO userDTO;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(@Lazy AuthenticationManager authenticationManager, UserRepo userRepo, UserDTO userDTO, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.userDTO = userDTO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRequestDTO userRequestDTO) {

        UserEntity user=new UserEntity();

        user.setFirstName(userRequestDTO.getFirstName());
        user.setSurname(userRequestDTO.getSurname());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        user.setRole(Role.CUSTOMER);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        userRepo.save(user);

    }

    @Override
    public UserDTO login(UserEntity user) {

       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));

        Optional<UserEntity> userEntity= userRepo.findByEmail(user.getEmail());

        if(userEntity.isPresent()){
            return userDTO.converToDTO(userEntity.get());
        }else {
            throw new ResourceNotFoundException("User does not exist");
        }
    }


}
