package com.liftapp.security.service;

import com.liftapp.model.Bean.User;
import com.liftapp.security.command.LoginCommand;
import com.liftapp.security.dto.LoginDTO;
import com.liftapp.security.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public AuthenticationServiceImpl(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        encoder = new BCryptPasswordEncoder();
    }

    @Override
    public Optional<LoginDTO> login(LoginCommand command) {
        Optional<User> user = userRepository.findByUsername(command.getUsername());

        if (user.isEmpty() || !isMatchingPassword(command.getPassword(), user.get().getPassword())) {
            return Optional.empty();
        }
        LoginDTO jwt_ = new LoginDTO(jwtService.createJwt(user.get()));
        return Optional.of(
                new LoginDTO(jwtService.createJwt(user.get()))
        );
    }

    @Override
    public Optional<User> register(User user){
        user.setPassword(
                encryptPassword(user.getPassword())
        );
        userRepository.save(user);
        return Optional.of(user);
    }

    private boolean isMatchingPassword(String rawPassword, String encryptedPassword) {
        return encoder.matches(rawPassword, encryptedPassword);
    }

    private String encryptPassword(String rawPassword){
        return encoder.encode(rawPassword);
    }
}
