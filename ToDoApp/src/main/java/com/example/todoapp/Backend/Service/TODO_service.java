package com.example.todoapp.Backend.Service;

import com.example.todoapp.Backend.Data.ToDoList;
import com.example.todoapp.Backend.Data.User;
import com.example.todoapp.Backend.repository.ToDoRepository;
import com.vaadin.flow.component.notification.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;
import java.util.List;


@Service
public class TODO_service  implements CrudListener<ToDoList> {


    private final ToDoRepository repository;
    private static ToDoRepository repository2;

    public TODO_service(ToDoRepository repository) {
        this.repository = repository;
        repository2 = repository;
    }

    @Override
    public Collection<ToDoList> findAll() {
        return (Collection<ToDoList>) repository.findAll();
    }

    public static Collection<ToDoList> findAllTODO() {
        return (Collection<ToDoList>) repository2.findAll();
    }

    public Collection<ToDoList> findAllTODOByUSERName(String username) {
        return repository.findAllTODOByUSERName(username);
    }

    @Override
    public ToDoList add(ToDoList toDoList) {
        return repository.save(toDoList);
    }

    public static void addByUser(String itemName, String descrp, String status_st, String date, String username) {
        repository2.savebyUser(itemName, descrp, status_st, date, username);
    }

    public static Integer updateByUser(String itemName, String descrp, String status_st, String username) {
       return repository2.updateByUser(itemName, descrp, status_st,username);
    }

    @Override
    public ToDoList update(ToDoList toDoList) {
        return repository.save(toDoList);
    }

    @Override
    public void delete(ToDoList toDoList) {
        repository.delete(toDoList);
    }
}
