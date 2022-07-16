package com.liftapp.repositories.JPARepos;

import com.liftapp.model.Bean.LU_JOB;
import com.liftapp.model.Bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAJobRepository extends JpaRepository<LU_JOB, Long> {
    List<LU_JOB> findAll();
    List<LU_JOB> findAllByDriverIsNull();

    @Modifying
    @Query("update LU_JOB set driver = ?1 where id = ?2")
    void assignJob(User user, Long jobId);
}
