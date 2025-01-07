package com.SkyHire.project.Service;

import com.SkyHire.project.Entity.UserDTO;
import com.SkyHire.project.Entity.UserEntity;
import org.apache.catalina.User;

public interface AuthenticationService {

    void register(UserEntity user);

    UserDTO login(UserEntity user);
}
