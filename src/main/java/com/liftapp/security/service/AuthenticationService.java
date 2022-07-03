package com.liftapp.security.service;

import com.liftapp.security.command.LoginCommand;
import com.liftapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {
    Optional<LoginDTO> login(LoginCommand command);
}
