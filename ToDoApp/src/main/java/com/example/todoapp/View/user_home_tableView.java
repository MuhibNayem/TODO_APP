package com.example.todoapp.View;

import com.example.todoapp.Backend.Data.ToDoList;
import com.example.todoapp.Backend.Data.User;
import com.example.todoapp.Backend.Service.Supervisor_Service;
import com.example.todoapp.Backend.Service.TODO_service;
import com.example.todoapp.Backend.Service.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.stream.Stream;

@Route("user-home")
public class user_home_tableView extends VerticalLayout {
    Grid<ToDoList> grid = new Grid<>(ToDoList.class);
    String UserName;
    static String name;
    TODO_service service;
    public user_home_tableView(TODO_service service) {
        this.service=service;
        if (name.equals("null")) {
            try {
                UI.getCurrent().navigate(Login_View.class);
            } catch (Exception e) {
                Notification.show("Error: " + e);
            } finally {
                UI.getCurrent().navigate(Login_View.class);
            }
        } else {

            addClassName("list-view");
            setSizeFull();


            Button addBtn = new Button("Add");
            addBtn.setId("AddBtn");
            Button editBtn = new Button("edit");
            editBtn.setId("editBtn");

            add(
                    new H2("Welcome User: " + name),
                    addBtn,
                    editBtn,
                    grid
            );

            configureGrid();
            updateGrid();

            editBtn.addClickListener(clickEvent -> {
                editTODO_view.setUsername(name);
                UI.getCurrent().navigate(editTODO_view.class);
            });

            addBtn.addClickListener(clickEvent -> {
                Add_ToDo__View.setUsername(name);
                UI.getCurrent().navigate(Add_ToDo__View.class);
            });

        }
    }

    private void updateGrid() {
        grid.setItems(service.findAllTODOByUSERName(name));
    }

    private void configureGrid() {
        grid.addClassName("supervisor-grid");
        grid.setSizeFull();
        grid.setColumns("title", "description", "status", "createdate");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    public static void setUsername(String username) {
        name = username;
    }
}
