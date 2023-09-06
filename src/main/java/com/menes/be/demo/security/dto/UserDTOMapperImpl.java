package com.menes.be.demo.security.dto;

import com.menes.be.demo.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapperImpl implements UserDTOMapper{

    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getDob()
        );
    }
}
