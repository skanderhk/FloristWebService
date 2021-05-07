package com.ipsas.WebService.Controllers;

import com.ipsas.WebService.Models.User;
import com.ipsas.WebService.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class DefaultController {

    private final UserService userService;

    public DefaultController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth")
    public ResponseEntity<User> ConnectedUser(Authentication authentication){
        String e = authentication.getName();
        User u = userService.findOneByUsername(e);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
