package com.SkyHire.project.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "User")
@Data
public class UserEntity implements UserDetails {
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "password",nullable = false)
    private String password;

    @Enumerated
    private Role role;

    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
