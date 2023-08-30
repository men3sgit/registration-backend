package com.menes.be.demo.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
@Data
@NoArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    public User(String fullName, LocalDate bod, String email, String password, Role role) {
        this.fullName = fullName;
        this.bod = bod;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 5,
            initialValue = 2
    )
    @GeneratedValue(generator = "user_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(
            nullable = false,
            length = 100
    )
    private String fullName;
    @Column(
            nullable = false
    )
    private LocalDate bod;
    @Column(
            nullable = false,
            unique = true
    )
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean enabled;
    private Boolean locked;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority granted = new SimpleGrantedAuthority(role.toString());
        return Collections.singletonList(granted);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
