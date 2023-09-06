package com.menes.be.demo.security.dto;

import com.menes.be.demo.user.User;

import java.util.function.Function;

public interface UserDTOMapper extends Function<User,UserDTO> {
}
