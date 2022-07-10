package com.liftapp.repositories.JPARepos;

import com.liftapp.model.Bean.LU_JOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAJobRepository extends JpaRepository<LU_JOB, Long> {
    List<LU_JOB> findAll();
}
