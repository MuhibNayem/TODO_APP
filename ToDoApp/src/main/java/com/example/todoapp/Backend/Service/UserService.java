package com.example.todoapp.Backend.Service;

import com.example.todoapp.Backend.Data.User;
import com.example.todoapp.Backend.repository.userRepository;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;
import java.util.List;

@Service

public class UserService implements CrudListener<User> {
    private final userRepository repository;
    private static userRepository repository2;

    public UserService(userRepository repository) {
        this.repository = repository;
        repository2 = repository;
    }

    @Override
    public Collection<User> findAll() {
        return (Collection<User>) repository.findAll();
    }

    public static Collection<User> findAllUser() {
        return (Collection<User>) repository2.findAll();
    }

    public User add(User user) {
        return repository.save(user);
    }


    public User update(User user) {
        return repository.save(user);
    }

    public List<String> validateUser(String username, String password) {
        return repository.validateUser(username,password);
    }

    public void delete(User user) {
        repository.delete(user);
    }

    public List<String> validateAdmin(String userName, String pass) {
        return repository.validateAdmin(userName,pass);
    }
}
