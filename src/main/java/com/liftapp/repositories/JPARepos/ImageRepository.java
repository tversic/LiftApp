package com.liftapp.repositories.JPARepos;

import com.liftapp.model.Bean.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);

}
