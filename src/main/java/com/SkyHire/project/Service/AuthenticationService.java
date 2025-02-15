package com.SkyHire.project.Service;

import com.SkyHire.project.Entity.UserDTO;
import com.SkyHire.project.Entity.UserEntity;
import com.SkyHire.project.Entity.UserRequestDTO;
import org.apache.catalina.User;

public interface AuthenticationService {

    void register(UserRequestDTO user);

    UserDTO login(UserEntity user);
}
