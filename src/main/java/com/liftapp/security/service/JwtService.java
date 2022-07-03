package com.liftapp.security.service;

import com.liftapp.model.Bean.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);
}
