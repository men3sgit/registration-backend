package com.menes.be.demo.registration;

import com.menes.be.demo.exception.ApiRequestException;
import com.menes.be.demo.user.Role;
import com.menes.be.demo.user.User;
import com.menes.be.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public String register(RegistrationRequest request) {
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new ApiRequestException("Email taken");
        }
        try {
            User user = new User();
            user.setBod(request.getDob());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRole(Role.USER);
            user.setFullName(request.getFullName());
            repository.save(user);
        } catch (ApiRequestException e) {
            throw new ApiRequestException(e.getMessage());
        }

        return "token";
    }
}
