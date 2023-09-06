package com.menes.be.demo.pub;

import com.menes.be.demo.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("api/v1/users")
@RestController
@RequiredArgsConstructor
public class UnsecureController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
}
