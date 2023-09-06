package com.menes.be.demo.user;

import com.menes.be.demo.registration.RegistrationRequest;
import com.menes.be.demo.security.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;


public interface UserService extends UserDetailsService {

    public void signUpUser(User user);

    List<UserDTO> getUsers();
}
