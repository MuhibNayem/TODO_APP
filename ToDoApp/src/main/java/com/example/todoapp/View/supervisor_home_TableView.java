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
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("supervisor-home")
public class supervisor_home_TableView extends VerticalLayout {
    Grid<ToDoList> grid_todo = new Grid<>(ToDoList.class);
    Grid<User> grid_user = new Grid<>(User.class);
    static String name;
    TODO_service service;

    public supervisor_home_TableView(TODO_service service) {
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


            var username = new TextField("username");
            username.setId("description-field");
            username.setPlaceholder("username here");
            username.setAutofocus(true);
            username.setClearButtonVisible(true);


            Button filterBtn = new Button("filter");
            filterBtn.setId("filter");

            Button refreshBtn = new Button("refresh");
            refreshBtn.setId("refresh");

            add(
                    new H2("Welcome Supervisor: " + name),

                    username,
                    filterBtn,
                    refreshBtn,
                    grid_todo
            );

            configureGrid();
            updateGrid();

            filterBtn.addClickListener(clickEvent -> {
                grid_todo.setItems(service.findAllTODOByUSERName(username.getValue()));
            });

            refreshBtn.addClickListener(clickEvent -> {
                updateGrid();
            });

        }
    }

    private void updateGrid() {
        grid_todo.setItems(TODO_service.findAllTODO());
    }

    private void configureGrid() {
        grid_todo.addClassName("supervisor-grid");
        grid_todo.setSizeFull();
        grid_todo.setColumns("title", "description", "status", "createdate");
        grid_todo.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    public static void setUsername(String username) {
        name = username;
    }
}
