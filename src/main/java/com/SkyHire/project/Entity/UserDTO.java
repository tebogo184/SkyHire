package com.SkyHire.project.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;


@Component
public class UserDTO {

    @NotNull
    private String firstName;
    @NotNull
    private String surname;

    @NotNull
    @Email
    private String email;
    @NotNull
    private Long userID;

    @NotNull
            private Role role;

    UserDTO(){}
    public UserDTO(String firstName,String surname,String email,Long userID,Role role) {
        this.firstName = firstName;
        this.surname=surname;
        this.email=email;
        this.userID=userID;
        this.role=role;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserDTO converToDTO(UserEntity user){

        return new UserDTO(user.getFirstName(), user.getSurname(), user.getEmail(), user.getUserID(),user.getRole());

    }


}
