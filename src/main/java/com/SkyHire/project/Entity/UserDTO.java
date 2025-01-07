package com.SkyHire.project.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotNull
    private String firstName;
    @NotNull
    private String surname;
    @Email
    private String email;
    @NotNull
    private Long Id;



    public UserDTO converToDTO(UserEntity user){

        return new UserDTO(user.getFirstName(), user.getSurname(), user.getEmail(), user.getUserID());

    }


}
