package com.menes.be.demo.security.dto;

import java.time.LocalDate;

public record UserDTO(
        Long id,
        String email,
        String fullName,
        LocalDate dob
) {
}
