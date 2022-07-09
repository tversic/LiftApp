package com.liftapp.security.controller;

import com.liftapp.model.Bean.User;
import com.liftapp.security.command.LoginCommand;
import com.liftapp.security.dto.LoginDTO;
import com.liftapp.security.service.AuthenticationService;
import com.liftapp.security.user.ApplicationUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("authentication")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class AuthenticationController {

    //private static Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public LoginDTO login(@Valid @RequestBody final LoginCommand command) {
        return authenticationService.login(command)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid credentials"));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody final User user){
        if(authenticationService.register(user).isPresent()){
            return ResponseEntity.ok().body(user);
        }else {
            log.error("Registration failed");
            return ResponseEntity.badRequest().build();
        }
    }
}
