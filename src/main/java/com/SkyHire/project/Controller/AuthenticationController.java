package com.SkyHire.project.Controller;

import com.SkyHire.project.Entity.UserEntity;
import com.SkyHire.project.Entity.UserRequestDTO;
import com.SkyHire.project.Service.Implementation.AuthenticationServiceImpl;
import com.SkyHire.project.Utility.ApiErrorResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class AuthenticationController {


    private final AuthenticationServiceImpl authService;

    AuthenticationController(AuthenticationServiceImpl authService){
        this.authService=authService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register( @Valid @RequestBody UserRequestDTO user){

            authService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User has been registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user){


        return ResponseEntity.status(HttpStatus.OK).body(authService.login(user));
    }

}
