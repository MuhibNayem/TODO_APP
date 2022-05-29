package com.example.todoapp.Backend.Data;

import com.example.todoapp.Backend.Data.Supervisor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;

    public User(String get_name, String get_username, String get_pssword) {
        this.name=get_name;
        this.username=get_username;
        this.password=get_pssword;
    }

    public User(String userName, String pass) {
        this.username=userName;
        this.password=pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    public List<ToDoList> getToDoLists() {
//        return toDoLists;
//    }

//    public void setToDoLists(List<ToDoList> toDoLists) {
//        this.toDoLists = toDoLists;
//    }


}
