package com.example.school.entities;

import com.example.school.entities.enums.UserType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Builder
public class Account implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Picture picture;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Account(String username, String email, String hashedPassword, UserType userType) {
        this.username=username;
        this.email=email;
        this.password=hashedPassword;
        this.userType= userType;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
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
    public String getUsername(){
        return username;
    }

    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userType.name()));
        return authorities;
    }
}
