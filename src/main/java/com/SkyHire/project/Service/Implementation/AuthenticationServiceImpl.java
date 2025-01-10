package com.SkyHire.project.Service.Implementation;

import com.SkyHire.project.Entity.Role;
import com.SkyHire.project.Entity.UserDTO;
import com.SkyHire.project.Entity.UserEntity;
import com.SkyHire.project.Repository.UserRepo;
import com.SkyHire.project.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthenticationServiceImpl implements AuthenticationService, UserDetailsService {





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
    public void register(UserEntity user) {

        user.setRole(Role.CUSTOMER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

    }

    @Override
    public UserDTO login(UserEntity user) {

        System.out.println("*********************About to authenticate user:+"+":"+user.getEmail()+user.getPassword()+"******************");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        System.out.println("*********************just finished authentication******************");

        Optional<UserEntity> userEntity= userRepo.findByEmail(user.getEmail());
        System.out.println("*********************about to find the user entity from the repo******************");

       if(userEntity.isPresent()){
           System.out.println("************User Entity is availble  **************");
           return userDTO.converToDTO(userEntity.get());
       }
       throw new RuntimeException("Username does not exist");



    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Failed to find user name"));
    }
}
