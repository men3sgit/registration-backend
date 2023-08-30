package com.menes.be.demo.registration;

import lombok.Builder;

@Builder
public record RegistrationResponse(
        String token
) {
}
