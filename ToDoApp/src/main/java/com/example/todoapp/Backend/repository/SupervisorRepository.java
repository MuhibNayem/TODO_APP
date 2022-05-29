package com.example.todoapp.Backend.repository;

import com.example.todoapp.Backend.Data.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE user set (assigned_supervisor) VALUES (:spervisorName) where username= :userName", nativeQuery = true)
    void assignUser(String userName, String spervisorName);
}
