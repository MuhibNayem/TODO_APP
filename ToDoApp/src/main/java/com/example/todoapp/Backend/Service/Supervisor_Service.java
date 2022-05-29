package com.example.todoapp.Backend.Service;

import com.example.todoapp.Backend.Data.Supervisor;
import com.example.todoapp.Backend.repository.SupervisorRepository;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service

public class Supervisor_Service implements CrudListener<Supervisor> {
    private final SupervisorRepository repository;
    private static SupervisorRepository repository2;

    public Supervisor_Service(SupervisorRepository repository) {
        this.repository = repository;
        repository2 = repository;
    }

    @Override
    public Collection<Supervisor> findAll() {
        return repository.findAll();
    }

    public static void assignUser(String username, String supervisor_name) {
        repository2.assignUser(username, supervisor_name);
    }

    @Override
    public Supervisor add(Supervisor supervisor) {
        return repository.save(supervisor);
    }

    @Override
    public Supervisor update(Supervisor supervisor) {
        return repository.save(supervisor);
    }

    @Override
    public void delete(Supervisor supervisor) {
        repository.delete(supervisor);
    }
}
