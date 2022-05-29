package com.example.todoapp.Backend.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supervisor {

    public Supervisor(String get_name, String get_username, String get_pssword) {
        this.name=get_name;
        this.username=get_username;
        this.password=get_pssword;
    }

    public Supervisor(String userName, String pass) {
        this.username=userName;
        this.password=pass;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupervisorID")
    private Long id;
    private String name;
    private String username;
    private String password;

    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_supervisor", referencedColumnName = "SupervisorID")
    @Column(name = "assigned_supervisor", columnDefinition = "text")
    private List<User> user;

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

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
