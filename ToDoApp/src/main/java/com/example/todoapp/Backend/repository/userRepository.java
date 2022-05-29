package com.example.todoapp.Backend.repository;

import com.example.todoapp.Backend.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userRepository  extends CrudRepository<User, Long> {

    @Query("SELECT username, password from User where username= :n and password =:p")
    List<String> validateUser(@Param("n") String username, @Param("p") String password);

    @Query("SELECT username, password from Supervisor where username= :n and password =:p")
    List<String> validateAdmin(@Param("n") String username, @Param("p") String password);

    @Query("SELECT username from User")
    List<String> findAllUser();
}
