package com.liftapp.security.service;

import com.liftapp.model.Bean.User;
import com.liftapp.security.command.LoginCommand;
import com.liftapp.security.dto.LoginDTO;
import com.liftapp.security.user.ApplicationUser;

import java.util.Optional;

public interface AuthenticationService {
    Optional<LoginDTO> login(LoginCommand command);

    Optional<User> register(User user);
}
