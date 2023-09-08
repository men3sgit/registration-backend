package com.menes.be.demo.user;

import com.menes.be.demo.exception.ApiRequestException;
import com.menes.be.demo.security.dto.UserDTO;
import com.menes.be.demo.security.dto.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserDTOMapper userDTOMapper;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    @Override
    public Long signUpUser(User user) {
        if(repository.findByEmail(user.getEmail()).isPresent()){
           throw new ApiRequestException("Email taken");
        }
        repository.save(user);
    return user.getId();
    }

    @Override
    public List<UserDTO> getUsers() {
        return repository
                .findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

}
