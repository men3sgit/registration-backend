package com.menes.be.demo.registration;

import com.menes.be.demo.user.User;
import com.menes.be.demo.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/auth/registration")
public class RegistrationController {
    private final RegistrationService service;

    @PostMapping
    public ResponseEntity<RegistrationResponse> registerNewUser(@RequestBody
                                                                RegistrationRequest request) {
        RegistrationResponse response = RegistrationResponse.builder()
                .token(service.register(request))
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
