package com.SkyHire.project.Controller;

import com.SkyHire.project.Entity.UserEntity;
import com.SkyHire.project.Service.Implementation.AuthenticationServiceImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {


    private final AuthenticationServiceImpl authService;

    AuthenticationController(AuthenticationServiceImpl authService){
        this.authService=authService;
    }
    @PostMapping("/register")
    public void register(@RequestBody UserEntity user){

        authService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user){

        return ResponseEntity.ok(authService.login(user));
    }

}
