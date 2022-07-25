package com.liftapp.services.implementations;

import com.liftapp.model.Bean.User;
import com.liftapp.model.DTO.UserDTO;
import com.liftapp.repositories.JPARepos.JpaUserRepository;
import com.liftapp.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JpaUserRepository jpaUserRepository;

    @Override
    public UserDTO getByUsername(String username) {
        return mapUserToUserDTO(jpaUserRepository.findByUsername(username));
    }

    private UserDTO mapUserToUserDTO(User u){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(u.getUsername());
        userDTO.setDateOfBirth(u.getDateOfBirth());
        userDTO.setFirst_name(u.getFirst_name());
        userDTO.setLast_name(u.getLast_name());
        userDTO.setSex(u.getSex());
        return userDTO;
    }
}
