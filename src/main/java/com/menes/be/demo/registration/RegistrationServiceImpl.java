package com.menes.be.demo.registration;

import com.menes.be.demo.exception.ApiRequestException;
import com.menes.be.demo.mail.EmailValidator;
import com.menes.be.demo.registration.token.ConfirmationTokenService;
import com.menes.be.demo.user.Role;
import com.menes.be.demo.user.User;
import com.menes.be.demo.user.UserRepository;
import com.menes.be.demo.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    @Override
    @Transactional
    public String register(RegistrationRequest request) {
        if(!EmailValidator.isValid(request.getEmail())){
            throw new ApiRequestException("Email invalid!");
        }
        try {
            User user = new User();
            user.setDob(request.getDob());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRole(Role.USER);
            user.setFullName(request.getFullName());
            userService.signUpUser(user);
        } catch (ApiRequestException e) {
            throw new ApiRequestException(e.getMessage());
        }


        return "token";
    }
}
