package com.liftapp.repositories.JPARepos;

import com.liftapp.model.Bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
