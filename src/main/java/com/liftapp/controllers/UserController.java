package com.liftapp.controllers;

import com.liftapp.model.Bean.User;
import com.liftapp.model.DTO.UserDTO;
import com.liftapp.services.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("getByUsername/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
        try {
            return ResponseEntity.ok().body(userService.getByUsername(username));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
