package com.example.todoapp.Backend.repository;

import com.example.todoapp.Backend.Data.ToDoList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ToDoRepository extends CrudRepository<ToDoList, Long> {
    @Query("from ToDoList where username= :u")
    Collection<ToDoList>  findAllTODOByUSERName(@Param("u") String username);

    @Query(value = "insert into to_do_list (title, description, status, Createdate, username) " +
            "VALUES (:itm, :d, :s, :dt, :usr)", nativeQuery = true)
    void savebyUser(@Param("itm")String itemName, @Param("d")String descrp, @Param("s")String status_st,
                    @Param("dt")String date, @Param("usr")String username);
    @Modifying
    @Transactional
    @Query("UPDATE ToDoList  SET  description= :descrp, status = :status_st WHERE username = :username and title = :itemName")
    Integer updateByUser(String itemName, String descrp, String status_st,String username);


}
