package com.ipsas.WebService.Controllers;

import com.ipsas.WebService.Models.User;
import com.ipsas.WebService.Services.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@OpenAPIDefinition(info = @Info(title = "Florist API",description = "Client Controller using OpenAPI",version = "2.0",
        contact = @Contact(
                name = "SkanderHk",
                email = "Skander.hkacem@gmail.com"))
                    )
public class DefaultController {

    private final UserService userService;

    public DefaultController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Connected User",description = "Return The connected User")
    @GetMapping("/auth")
    public ResponseEntity<User> ConnectedUser(Authentication authentication){
        String e = authentication.getName();
        User u = userService.findOneByUsername(e);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
