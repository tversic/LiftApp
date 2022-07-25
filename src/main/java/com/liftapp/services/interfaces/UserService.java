package com.liftapp.services.interfaces;

import com.liftapp.model.Bean.User;
import com.liftapp.model.DTO.UserDTO;

public interface UserService {
    UserDTO getByUsername(String username);
}
